package com.br.sanson.application.billingNotify.listener;

import com.br.sanson.domain.model.billingNotify.BillingNotification;
import com.br.sanson.domain.model.messageconfig.MessageConfig;
import com.br.sanson.domain.model.messageconfig.MessageConfigRepository;
import com.br.sanson.domain.model.sms.SmsRepository;
import com.br.sanson.domain.shared.Msisdn;
import com.br.sanson.domain.shared.Tenant;
import com.br.sanson.exception.ResourceNotFoundException;
import com.br.sanson.infrastructure.clients.SmsSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Created by pc on 06/02/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class BillingNotifyListenerTest {

    @InjectMocks
    private BillingNotifyListener billingNotifyListener;

    @Mock
    private MessageConfigRepository messageConfigRepository;

    @Mock
    private SmsRepository smsRepository;

    @Mock
    private SmsSender smsSender;

    @Test
    public void eventoDePagamentoEnviandoSmsComSucesso(){
        Optional<MessageConfig> messageConfig = Optional.of(creatMessageConfig());

        when(messageConfigRepository.findByEventTypeAndTenant(anyString(),anyString())).thenReturn(messageConfig);

        billingNotifyListener.onApplicationEvent(createBillingNotification());

        verify(messageConfigRepository,times(1)).findByEventTypeAndTenant(anyString(),anyString());
        verify(smsSender,times(1)).sendSms(anyString(),anyString());


    }

    @Test(expected = ResourceNotFoundException.class)
    public void eventoDePagamentoSemConfiguracaoParaOTenant(){
        when(messageConfigRepository.findByEventTypeAndTenant(anyString(),anyString())).thenReturn(Optional.empty());

        billingNotifyListener.onApplicationEvent(createBillingNotification());

    }

    private BillingNotification createBillingNotification(){
        Msisdn msisdn = new Msisdn("55219859859855");
        Tenant tenant = new Tenant("tenant");
        String[] params = {"1","2"};

        return new BillingNotification(tenant,msisdn,params);
    }

    private MessageConfig creatMessageConfig(){

        return new MessageConfig("message","event","");
    }

}