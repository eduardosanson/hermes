package com.br.sanson.aplication.billingNotify.listener;

import com.br.sanson.aplication.config.MessageConfig;
import com.br.sanson.aplication.domain.BillingNotification;
import com.br.sanson.aplication.domain.Mensagem;
import com.br.sanson.aplication.domain.Sms;
import com.br.sanson.aplication.repository.MessagingRepository;
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

    private MessagingRepository repository;

    @Autowired
    BillingNotifyListener(MessagingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(BillingNotification billingNotification) {
        logger.info("notificacao Recebida" + billingNotification);

        MessageConfig config = repository.findByEventTypeAndTenant("billingEvent",billingNotification.tenant().asString());
        Mensagem message= new Mensagem(config.message());

        Sms sms = new Sms(message,billingNotification.msisdn());
        logger.info("enviando a mensagem" + sms);

    }
}
