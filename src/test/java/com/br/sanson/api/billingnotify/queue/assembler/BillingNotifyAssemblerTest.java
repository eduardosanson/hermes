package com.br.sanson.api.billingnotify.queue.assembler;

import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import com.br.sanson.domain.model.billingNotify.BillingNotification;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pc on 06/02/2017.
 */
public class BillingNotifyAssemblerTest {

    @Test
    public void parametrosDeSaidaIdenticosAosDeEntrada(){
        BillingNotifyTO billingNotifyTO = creaBillingNotifyTO();
        BillingNotification billingNotification = BillingNotifyAssembler.toNotification(billingNotifyTO);

        Assert.assertEquals(billingNotification.msisdn().asString(),billingNotifyTO.getMsisdn());
        Assert.assertEquals(billingNotification.tenant().asString(),billingNotifyTO.getTenant());
        Assert.assertArrayEquals(billingNotification.params(),billingNotifyTO.getParams());

    }

    private BillingNotifyTO creaBillingNotifyTO(){
        BillingNotifyTO billingNotifyTO = new BillingNotifyTO();
        billingNotifyTO.setMsisdn("5521981717170");
        billingNotifyTO.setTenant("tenat");
        String[] params = {"2","3"};
        billingNotifyTO.setParams(params);
        return billingNotifyTO;
    }

}