package com.br.sanson.domain.model.billingNotify;

import com.br.sanson.domain.shared.Msisdn;
import com.br.sanson.domain.shared.Tenant;
import org.springframework.context.ApplicationEvent;
import org.springframework.util.ObjectUtils;

/**
 * Created by pc on 04/02/2017.
 */
public class BillingNotification extends ApplicationEvent{

    private Tenant tenant;

    private Msisdn msisdn;

    private String[] params;

    public BillingNotification(Tenant tenant, Msisdn msisdn,String[] params) {
        super(tenant);
        if (ObjectUtils.isEmpty(tenant)||ObjectUtils.isEmpty(msisdn)){
            throw new IllegalArgumentException("Msisdn ou Tenant não podem ser nulos");
        }
        this.tenant = tenant;
        this.msisdn = msisdn;
        this.params=params;
    }

    public Tenant tenant(){
        return tenant;
    }

    public Msisdn msisdn(){
        return msisdn;
    }

    public String[] params(){
        return params;
    }

    @Override
    public String toString() {
        return "BillingNotification{" +
                "tenant=" + tenant +
                ", msisdn=" + msisdn +
                '}';
    }
}
