package com.br.sanson.api.billingnotify.queue;

import com.br.sanson.api.billingnotify.queue.assembler.BillingNotifyAssembler;
import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import com.br.sanson.aplication.interfaces.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pc on 04/02/2017.
 */
public class BillingNotifyQueue {


    private NotifyService service;

    @Autowired
    BillingNotifyQueue(NotifyService service) {
        this.service = service;
    }

    public void billingNotification(BillingNotifyTO billingNotify){

        service.notify(BillingNotifyAssembler.toNotification(billingNotify));

    }
}
