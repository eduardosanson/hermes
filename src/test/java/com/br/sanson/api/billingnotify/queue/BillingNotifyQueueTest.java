package com.br.sanson.api.billingnotify.queue;

import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import com.br.sanson.infrastructure.interfaces.NotifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by pc on 04/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BillingNotifyQueueTest {

    @Mock
    private NotifyService service;

    @InjectMocks
    private BillingNotifyQueue billingNotifyQueue;

    @Test
    public void notificacaoDePagamentoComSucesso(){

        billingNotifyQueue.billingNotification(creaBillingNotifyTO());

        Mockito.verify(service,Mockito.times(1)).notify(Mockito.any());
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