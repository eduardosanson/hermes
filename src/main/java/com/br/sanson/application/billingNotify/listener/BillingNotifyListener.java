package com.br.sanson.application.billingNotify.listener;

import com.br.sanson.domain.config.MessageConfig;
import com.br.sanson.domain.BillingNotification;
import com.br.sanson.domain.Mensagem;
import com.br.sanson.domain.Sms;
import com.br.sanson.repository.MessageConfigRepository;
import com.br.sanson.repository.SmsRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by pc on 04/02/2017.
 */
@Component
public class BillingNotifyListener implements ApplicationListener<BillingNotification> {

    private static final Logger logger = Logger.getLogger(BillingNotifyListener.class);

    private MessageConfigRepository repository;

    private SmsRepository smsRepository;

    private static final String BILLING_EVENT_TYPE="billingEvent";

    @Autowired
    BillingNotifyListener(MessageConfigRepository repository,SmsRepository smsRepository) {
        this.repository = repository;
        this.smsRepository = smsRepository;
    }

    @Override
    public void onApplicationEvent(BillingNotification billingNotification) {
        logger.info("notificacao Recebida" + billingNotification);

        MessageConfig config = repository.findByEventTypeAndTenant(BILLING_EVENT_TYPE,billingNotification.tenant().asString());
        Mensagem message= new Mensagem(config.message());

        Sms sms = new Sms(message,billingNotification.msisdn());
        smsRepository.save(sms);

    }
}
