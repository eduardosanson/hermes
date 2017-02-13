package com.br.sanson.domain.model.messageconfig;

import com.br.sanson.domain.shared.enums.EventType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by pc on 04/02/2017.
 */
@Document
public class MessageConfig {

    @Id
    private String id;

    private String message;

    private EventType eventType;

    private String tenant;

    @JsonCreator
    public MessageConfig(@JsonProperty(value = "message") String message, @JsonProperty(value = "eventType") EventType eventType, @JsonProperty(value = "tenant") String tenant) {
        this.message = message;
        this.eventType = eventType;
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "MessageConfig{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", eventType='" + eventType + '\'' +
                ", tenant='" + tenant + '\'' +
                '}';
    }

    public MessageConfig() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MessageConfig config = (MessageConfig) o;
        return Objects.equals(id, config.id) &&
                Objects.equals(message, config.message) &&
                Objects.equals(eventType, config.eventType) &&
                Objects.equals(tenant, config.tenant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, eventType, tenant);
    }

    @JsonProperty
    public String message(){
        return message;
    }

    @JsonProperty
    public String tenant(){
        return tenant;
    }

    @JsonProperty
    public EventType eventType(){
        return eventType;
    }

}
