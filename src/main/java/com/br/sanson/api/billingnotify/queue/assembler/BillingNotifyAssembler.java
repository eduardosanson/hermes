package com.br.sanson.api.billingnotify.queue.assembler;

import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import com.br.sanson.domain.model.billingNotify.BillingNotification;
import com.br.sanson.domain.shared.Msisdn;
import com.br.sanson.domain.shared.Tenant;

import java.util.Optional;

/**
 * Created by pc on 04/02/2017.
 */
public class BillingNotifyAssembler {

    public static BillingNotification toNotification(BillingNotifyTO billingNotify){
        Tenant tenant = new Tenant(Optional.ofNullable(billingNotify.getTenant())
                .orElseThrow(()-> new IllegalArgumentException("Tenant é obrigatório")));
        Msisdn msisdn = new Msisdn(Optional.ofNullable(billingNotify.getMsisdn())
                .orElseThrow(() -> new IllegalArgumentException("Msisdn é obrigatório")));


        return new BillingNotification(tenant,msisdn,billingNotify.getParams());
    }
}
