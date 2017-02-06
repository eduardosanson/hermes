package com.br.sanson.domain.model.eventError;

import com.br.sanson.infrastructure.util.JsonUtil;
import org.springframework.amqp.core.Message;
import org.springframework.data.annotation.Id;

/**
 * Created by pc on 05/02/2017.
 */
public class EventError<T> {

    @Id
    private String id;
    private T body;
    private final String originalExchange;
    private final String originalQueue;
    private final String exceptionDescription;
    private final String contentType;
    private final String dlqName;


    public EventError(Message message, Class<T> clazz) {
        this.body = JsonUtil.fromJson(new String(message.getBody()),clazz);
        this.dlqName = message.getMessageProperties().getConsumerQueue();
        this.originalExchange = message.getMessageProperties().getReceivedExchange();
        this.originalQueue = message.getMessageProperties().getReceivedRoutingKey();
        this.exceptionDescription = message.getMessageProperties().getHeaders().get("x-exception-stacktrace").toString();
        this.contentType = message.getMessageProperties().getContentType();
    }
}
