package com.br.sanson.application.billingNotify.listener;

import com.br.sanson.domain.model.messageconfig.MessageConfig;
import com.br.sanson.domain.model.billingNotify.BillingNotification;
import com.br.sanson.domain.shared.Mensagem;
import com.br.sanson.domain.model.sms.Sms;
import com.br.sanson.domain.model.messageconfig.MessageConfigRepository;
import com.br.sanson.domain.model.sms.SmsRepository;
import com.br.sanson.exception.ResourceNotFoundException;
import com.br.sanson.infrastructure.clients.SmsSender;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by pc on 04/02/2017.
 */
@Component
public class BillingNotifyListener implements ApplicationListener<BillingNotification> {

    private static final Logger logger = Logger.getLogger(BillingNotifyListener.class);

    private MessageConfigRepository repository;

    private SmsRepository smsRepository;

    private static final String BILLING_EVENT_TYPE="billingEvent";

    private SmsSender smsSender;

    @Autowired
    BillingNotifyListener(MessageConfigRepository repository,
                          SmsRepository smsRepository,
                          SmsSender smsSender) {
        this.repository = repository;
        this.smsRepository = smsRepository;
        this.smsSender = smsSender;
    }

    @Override
    public void onApplicationEvent(BillingNotification billingNotification) {
        logger.info("notificacao Recebida " + billingNotification);

        MessageConfig config = repository.findByEventTypeAndTenant(BILLING_EVENT_TYPE,billingNotification.tenant().asString())
                .orElseThrow(()-> new ResourceNotFoundException(MessageConfig.class,BILLING_EVENT_TYPE,billingNotification.tenant()));
        Mensagem message= new Mensagem(config.message());

        Sms sms = new Sms(message,billingNotification.msisdn());
        smsSender.sendSms(sms.mensagem().asString(),sms.destination().asString());
        smsRepository.save(sms);

    }
}
