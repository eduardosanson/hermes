package com.br.sanson.api.billingnotify.queue.assembler;

import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import com.br.sanson.aplication.domain.*;

/**
 * Created by pc on 04/02/2017.
 */
public class BillingNotifyAssembler {

    public static BillingNotification toNotification(BillingNotifyTO billingNotify){
        Tenant tenant = new Tenant(billingNotify.getTenant());
        Msisdn msisdn = new Msisdn(billingNotify.getMsisdn());

        return new BillingNotification(tenant,msisdn);
    }
}
