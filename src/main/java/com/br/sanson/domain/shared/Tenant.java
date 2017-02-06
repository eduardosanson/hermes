package com.br.sanson.domain.shared;

import java.util.Optional;

/**
 * Created by pc on 04/02/2017.
 */
public class Tenant {

    private String tenant;

    public Tenant(String tenant) {
        this.tenant = Optional
                .ofNullable(tenant)
                .orElseThrow(()->  new IllegalArgumentException("Tenant não pode ser nulo"));
    }

    public String asString(){
        return tenant;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "value='" + tenant + '\'' +
                '}';
    }
}
