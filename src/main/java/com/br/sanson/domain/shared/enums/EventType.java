package com.br.sanson.domain.shared.enums;

/**
 * Created by pc on 05/02/2017.
 */
public enum EventType {
    BILLING("billingEvent");

    private String value;

    EventType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
