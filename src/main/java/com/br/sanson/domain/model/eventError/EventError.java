package com.br.sanson.domain.model.eventError;

import com.br.sanson.infrastructure.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.amqp.core.Message;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by pc on 05/02/2017.
 */
@Document
public class EventError<T> {

    @Id
    private String id;
    private T body;
    private String originalExchange;
    private String originalQueue;
    private String exceptionDescription;
    private String contentType;
    private String dlqName;

    public EventError(Message message, Class<T> clazz) {
        this.body = JsonUtil.fromJson(new String(message.getBody()),clazz);
        this.dlqName = message.getMessageProperties().getConsumerQueue();
        this.originalExchange = message.getMessageProperties().getReceivedExchange();
        this.originalQueue = message.getMessageProperties().getReceivedRoutingKey();
        this.exceptionDescription = message.getMessageProperties().getHeaders().get("x-exception-stacktrace").toString();
        this.contentType = message.getMessageProperties().getContentType();
    }

    @JsonCreator
    public EventError(T body, String originalExchange, String originalQueue, String exceptionDescription, String contentType, String dlqName) {
        this.body = body;
        this.originalExchange = originalExchange;
        this.originalQueue = originalQueue;
        this.exceptionDescription = exceptionDescription;
        this.contentType = contentType;
        this.dlqName = dlqName;
    }

    public EventError() {
    }

    @JsonProperty
    public T body() {
        return body;
    }

    @JsonProperty
    public String originalExchange() {
        return originalExchange;
    }

    @JsonProperty
    public String getOriginalQueue() {
        return originalQueue;
    }

    @JsonProperty
    public String exceptionDescription() {
        return exceptionDescription;
    }

    @JsonProperty
    public String contentType() {
        return contentType;
    }

    @JsonProperty
    public String dlqName() {
        return dlqName;
    }
}
