package com.br.sanson.api.billingnotify.web;

import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import com.br.sanson.infrastructure.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by pc on 06/02/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class BillingNotifyControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private BillingNotifyController controller;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @Before
    public void prepareForTest(){
        this.mockMvc = standaloneSetup(controller).alwaysDo(print()).build();
    }

    @Test
    public void chamarNotificacaoDePagamentoComSucesso() throws Exception {
        BillingNotifyTO notifyTO = creaBillingNotifyTO();

        String json = JsonUtil.toJson(notifyTO);

        mockMvc.perform(post("/billingNotify")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json))
                .andExpect(status().isAccepted());
    }

    @Test
    public void chamarNotificacaoDePagamentoComFalha() throws Exception {
        mockMvc.perform(post("/billingNotify")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
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