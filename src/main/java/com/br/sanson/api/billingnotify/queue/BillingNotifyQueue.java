package com.br.sanson.api.billingnotify.queue;

import com.br.sanson.api.billingnotify.queue.assembler.BillingNotifyAssembler;
import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import com.br.sanson.infrastructure.interfaces.EventDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Created by pc on 04/02/2017.
 */
@EnableBinding(EventDestination.class)
public class BillingNotifyQueue {


    private ApplicationEventPublisher eventPublisher;

    @Autowired
    BillingNotifyQueue(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;

    }


    @StreamListener(EventDestination.BILLING_NOTIFY_EVENT)
    public void billingNotification(BillingNotifyTO billingNotify){

        eventPublisher.publishEvent(BillingNotifyAssembler.toNotification(billingNotify));

    }
}
