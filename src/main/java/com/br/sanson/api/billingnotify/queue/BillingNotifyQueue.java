package com.br.sanson.api.billingnotify.queue;

import com.br.sanson.api.billingnotify.queue.assembler.BillingNotifyAssembler;
import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import com.br.sanson.infrastructure.interfaces.EventDestination;
import com.br.sanson.infrastructure.interfaces.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by pc on 04/02/2017.
 */
@EnableBinding(EventDestination.class)
public class BillingNotifyQueue {


    private NotifyService service;

    @Autowired
    BillingNotifyQueue(NotifyService service) {
        this.service = service;
    }


    @StreamListener(EventDestination.BILLING_NOTIFY_EVENT)
    public void billingNotification(BillingNotifyTO billingNotify){

        service.notify(BillingNotifyAssembler.toNotification(billingNotify));

    }
}
