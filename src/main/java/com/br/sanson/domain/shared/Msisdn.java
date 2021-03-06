package com.br.sanson.domain.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

/**
 * Created by pc on 04/02/2017.
 */
public class Msisdn {

    private String msisdn;

    @JsonCreator
    public Msisdn(String msisdn) {
        this.msisdn = Optional
                .ofNullable(msisdn)
                .orElseThrow(()->  new IllegalArgumentException("Msisdn não pode ser nulo"));
    }

    public String asString(){
        return msisdn;
    }

    public Msisdn() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Msisdn msisdn1 = (Msisdn) o;

        return msisdn.equals(msisdn1.msisdn);

    }

    @Override
    public int hashCode() {
        return msisdn != null ? msisdn.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Msisdn{" +
                "value='" + msisdn + '\'' +
                '}';
    }

    @JsonProperty
    public String msisdn() {
        return msisdn;
    }
}
