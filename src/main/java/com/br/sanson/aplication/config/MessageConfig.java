package com.br.sanson.aplication.config;

import org.springframework.data.annotation.Id;

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

    public String message(){
        return message;
    }
}
