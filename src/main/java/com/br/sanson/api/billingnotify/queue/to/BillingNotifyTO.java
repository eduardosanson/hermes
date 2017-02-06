package com.br.sanson.api.billingnotify.queue.to;

/**
 * Created by pc on 04/02/2017.
 */
public class BillingNotifyTO {

    private String msisdn;

    private String tenant;

    private String[] params;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }
}
