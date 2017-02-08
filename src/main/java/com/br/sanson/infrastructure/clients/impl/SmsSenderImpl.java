package com.br.sanson.infrastructure.clients.impl;

import com.br.sanson.exception.FalhaDeComunicacaoException;
import com.br.sanson.infrastructure.clients.SmsSender;
import feign.FeignException;
import org.apache.log4j.Logger;

/**
 * Created by pc on 05/02/2017.
 */
public class SmsSenderImpl implements SmsSender {

    private FeignException feignException;

    private static final Logger logger = Logger.getLogger(SmsSenderImpl.class);

    public SmsSenderImpl(FeignException feignException) {
        this.feignException = feignException;
    }

    @Override
    public void sendSms(String mensagem, String msisdn) {
        throw new FalhaDeComunicacaoException(SmsSender.class,feignException.status(),feignException,msisdn,mensagem);
    }
}
