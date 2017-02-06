package com.br.sanson.api.billingnotify.web;

import com.br.sanson.api.billingnotify.queue.assembler.BillingNotifyAssembler;
import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import com.br.sanson.application.billingNotify.service.BillingNotifyService;
import com.br.sanson.infrastructure.interfaces.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pc on 04/02/2017.
 */
@RestController
@RequestMapping(path = "/billingNotify")
public class BillingNotifyController {

    private NotifyService service;

    @Autowired
    BillingNotifyController(BillingNotifyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Void> billingNofication(BillingNotifyTO billingNotifyTO){

        service.notify(BillingNotifyAssembler.toNotification(billingNotifyTO));

        return ResponseEntity.accepted().build();
    }
}
