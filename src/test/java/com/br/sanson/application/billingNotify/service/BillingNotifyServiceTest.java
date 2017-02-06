package com.br.sanson.application.billingNotify.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.Assert.*;

/**
 * Created by pc on 06/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BillingNotifyServiceTest {

    @InjectMocks
    private BillingNotifyService billingNotifyService;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @Test
    public void servicoDeNotificacaoComSucesso(){

        billingNotifyService.notify(Mockito.any());

        Mockito.verify(eventPublisher,Mockito.times(1)).publishEvent(Mockito.any());
    }

}