package com.br.sanson.aplication.billingNotify.service;

import com.br.sanson.aplication.interfaces.NotifyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Created by pc on 04/02/2017.
 */
@Service
public class BillingNotifyService implements NotifyService{

    private ApplicationEventPublisher eventPublisher;

    private static final Logger logger = Logger.getLogger(BillingNotifyService.class);

    @Autowired
    BillingNotifyService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void notify(ApplicationEvent billingNotification) {

        eventPublisher.publishEvent(billingNotification);

    }

}
