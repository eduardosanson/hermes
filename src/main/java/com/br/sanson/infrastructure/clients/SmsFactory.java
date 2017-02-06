package com.br.sanson.infrastructure.clients;

import com.br.sanson.infrastructure.clients.impl.SmsSenderImpl;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by pc on 05/02/2017.
 */
@Component
public class SmsFactory implements FallbackFactory<SmsSender> {
    @Override
    public SmsSender create(Throwable throwable) {
        FeignException fe = null;
        if(throwable instanceof FeignException) {
            fe = (FeignException) throwable;
        }
        return new SmsSenderImpl(fe);
    }
}
