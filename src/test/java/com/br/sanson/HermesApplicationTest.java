package com.br.sanson;

import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;
import com.br.sanson.domain.model.messageconfig.MessageConfig;
import com.br.sanson.domain.model.messageconfig.MessageConfigRepository;
import com.br.sanson.domain.shared.enums.EventType;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.ContextIdApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testcontainers.containers.GenericContainer;

import static org.junit.Assert.*;

/**
 * Created by sanson on 15/05/17.
// */
//@RunWith(SpringRunner.class)
////@SpringBootTest
//@ContextConfiguration
public class HermesApplicationTest {

    public static GenericContainer mongoDB = new GenericContainer("sameersbn/mongodb:latest")
            .withExposedPorts(27017);
//
//    @Autowired
//    private ContextIdApplicationContextInitializer contextInitializer;

    @MockBean
    private MessageConfigRepository messageConfigRepository;

    private Logger logger = Logger.getLogger(HermesApplicationTest.class);

    @Before
    public void init() throws JoranException {
        logger.info("iniciando o container");
        mongoDB.start();
    }

//    @Test
//    public void teste(){
//        MessageConfig messageConfig = new MessageConfig("teste", EventType.BILLING,"teste");
//        messageConfigRepository.save(messageConfig);
//
//        logger.info(messageConfigRepository.findByEventTypeAndTenant(EventType.BILLING,"teste"));
//    }




}