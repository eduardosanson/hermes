package com.br.sanson;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.GenericContainer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HermesApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public abstract class AbstractIntegrationTest {

    @ClassRule
    public static GenericContainer mongoDB = new GenericContainer("sameersbn/mongodb:latest").withExposedPorts(27017);

    @ClassRule
    public static GenericContainer rabbit = new GenericContainer("rabbitmq:3-management").withExposedPorts(15672).withExposedPorts(5672);

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            EnvironmentTestUtils.addEnvironment("testcontainers", configurableApplicationContext.getEnvironment(),
                    "spring.data.mongodb.host=" + mongoDB.getContainerIpAddress(),
                    "spring.data.mongodb.port=" + mongoDB.getMappedPort(27017),
                    "spring.rabbitmq.host" + rabbit.getContainerIpAddress(),
                    "spring.rabbitmq.port" + rabbit.getMappedPort(5672)
            );
        }
    }

}
