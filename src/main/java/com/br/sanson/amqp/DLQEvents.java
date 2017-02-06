package com.br.sanson.amqp;

import com.br.sanson.api.billingnotify.queue.to.BillingNotifyTO;
import com.br.sanson.domain.model.eventError.EventError;
import com.br.sanson.domain.model.eventError.EventErrorRepository;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pc on 05/02/2017.
 */
@Component
public class DLQEvents {

    private EventErrorRepository repository;

    private static final Logger logger = Logger.getLogger(DLQEvents.class);

    private static final long MAX_ATTEMPTS = 10;

    @Autowired
    DLQEvents(EventErrorRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues="${billingNotifyInput.queue.dlq}")
    public void billingNotify(Message message){
        saveDLQ(message, BillingNotifyTO.class);

    }

    private <T> void saveDLQ(Message message, Class<T> clazz) {
        try {
            logger.error("Exception Message: " + message.getMessageProperties().getHeaders().get("x-exception-stacktrace"));
            repository.save(new EventError(message, clazz));
        } catch (Exception e) {
            if (message.getMessageProperties().getDeliveryTag() >= MAX_ATTEMPTS) {
                logger.info("DLQ name: " + message.getMessageProperties().getHeaders().get("x-original-routingKey"));
                logger.info("Original Queue: " + message.getMessageProperties().getReceivedRoutingKey());
                logger.info("Original Exchange: " + message.getMessageProperties().getHeaders().get("x-original-exchange"));
                logger.info("Exception Message: " + message.getMessageProperties().getHeaders().get("x-exception-stacktrace"));
                logger.info("Content-Type: " + message.getMessageProperties().getContentType());
                logger.info("Body " + new String(message.getBody()));
                logger.error("Nao foi possivel processar a mensagem na DLQ");
            } else {
                logger.warn("Falha ao processar a mensagem na DLQ: " + e.getMessage()
                        + ". Tenantiva " + message.getMessageProperties().getDeliveryTag() + "/" + MAX_ATTEMPTS);
                throw e;
            }
        }
    }
}
