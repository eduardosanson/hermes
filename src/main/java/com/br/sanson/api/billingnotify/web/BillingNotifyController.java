package com.br.sanson.api.billingnotify.web;

import com.br.sanson.api.billingnotify.queue.assembler.BillingNotifyAssembler;
import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pc on 04/02/2017.
 */
@RestController
@RequestMapping(path = "/billingNotify")
public class BillingNotifyController {

    private ApplicationEventPublisher eventPublisher;

    @Autowired
    BillingNotifyController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> billingNofication(@RequestBody BillingNotifyTO billingNotifyTO){

        eventPublisher.publishEvent(BillingNotifyAssembler.toNotification(billingNotifyTO));

        return ResponseEntity.accepted().build();
    }
}
