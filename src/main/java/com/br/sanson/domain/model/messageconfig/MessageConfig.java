package com.br.sanson.domain.model.messageconfig;

import org.springframework.data.annotation.Id;

import java.util.Objects;

/**
 * Created by pc on 04/02/2017.
 */
public class MessageConfig {

    @Id
    private String id;

    private String message;

    private String eventType;

    private String tenant;

    public MessageConfig(String message, String eventType, String tenant) {
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

    public String message(){
        return message;
    }
}
