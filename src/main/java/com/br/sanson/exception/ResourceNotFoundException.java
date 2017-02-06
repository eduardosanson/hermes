package com.br.sanson.exception;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by pc on 05/02/2017.
 */
public class ResourceNotFoundException extends RuntimeException {

    private static final Logger logger = Logger.getLogger(ResourceNotFoundException.class);

    public <T> ResourceNotFoundException(Class<T> recurso, Object... params) {
        super("Nao existe " + recurso.getSimpleName() + " para os parametros " + Arrays.toString(params));
        logger.error("Nao existe " + recurso.getSimpleName() + " para os parametros " + Arrays.toString(params));
    }
}
