package com.br.sanson.domain;

import org.springframework.context.ApplicationEvent;
import org.springframework.util.ObjectUtils;

/**
 * Created by pc on 04/02/2017.
 */
public class BillingNotification extends ApplicationEvent{

    private Tenant tenant;

    private Msisdn msisdn;

    public BillingNotification(Tenant tenant, Msisdn msisdn) {
        super(tenant);
        if (ObjectUtils.isEmpty(tenant)||ObjectUtils.isEmpty(msisdn)){
            throw new IllegalArgumentException("Msisdn ou Tenant não podem ser nulos");
        }
        this.tenant = tenant;
        this.msisdn = msisdn;
    }

    public Tenant tenant(){
        return tenant;
    }

    public Msisdn msisdn(){
        return msisdn;
    }

    @Override
    public String toString() {
        return "BillingNotification{" +
                "tenant=" + tenant +
                ", msisdn=" + msisdn +
                '}';
    }
}
