package com.br.sanson;

import ch.qos.logback.core.joran.spi.JoranException;
import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * Created by sanson on 15/05/17.
// */
public class HermesApplicationTest extends AbstractIntegrationTest {

    private Logger logger = Logger.getLogger(HermesApplicationTest.class);

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void init() throws JoranException {
    }

    @Test
    public void teste(){
        BillingNotifyTO notifyTO = new BillingNotifyTO();

        notifyTO.setMsisdn("5363132");
        notifyTO.setTenant("tenant2");
//        notifyTO.setParams();

        restTemplate.postForEntity("/billingNotify",notifyTO, Object.class,notifyTO);

    }




}