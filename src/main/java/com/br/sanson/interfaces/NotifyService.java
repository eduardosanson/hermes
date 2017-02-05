package com.br.sanson.interfaces;

import org.springframework.context.ApplicationEvent;

/**
 * Created by pc on 04/02/2017.
 */
public interface NotifyService {

    void notify(ApplicationEvent billingNotification);
}
