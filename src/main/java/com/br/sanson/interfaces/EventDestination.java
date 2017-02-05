package com.br.sanson.interfaces;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by pc on 05/02/2017.
 */
public interface EventDestination {

    String BILLING_NOTIFY_EVENT ="billingNotifyInput";

    @Input(BILLING_NOTIFY_EVENT)
    SubscribableChannel billingNotify();
}
