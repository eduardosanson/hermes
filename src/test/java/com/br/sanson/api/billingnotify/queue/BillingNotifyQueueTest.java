package com.br.sanson.api.billingnotify.queue;

import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Created by pc on 04/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BillingNotifyQueueTest {

    @InjectMocks
    private BillingNotifyQueue billingNotifyQueue;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @Test
    public void notificacaoDePagamentoComSucesso(){

        billingNotifyQueue.billingNotification(creaBillingNotifyTO());

//        Mockito.verify(service,Mockito.times(1)).notify(Mockito.any());
        Mockito.verify(eventPublisher).publishEvent(Mockito.any());
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