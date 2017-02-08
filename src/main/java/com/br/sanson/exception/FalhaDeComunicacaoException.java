package com.br.sanson.exception;

import com.br.sanson.infrastructure.clients.SmsSender;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by pc on 05/02/2017.
 */
public class FalhaDeComunicacaoException extends RuntimeException {

    private static final Logger logger = Logger.getLogger(FalhaDeComunicacaoException.class);

    public <T> FalhaDeComunicacaoException(Class<T> recurso, int status, RuntimeException re,Object... params) {
        super("Erro na chamada " + recurso.getSimpleName() +  " response code " + status + " para os parametros " + Arrays.toString(params),re);
        logger.error("Erro na chamada " + recurso.getSimpleName() + " response code " + status +" para os parametros " + Arrays.toString(params));
    }

}
