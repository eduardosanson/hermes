package com.br.sanson.infrastructure.util;

import com.google.gson.GsonBuilder;

/**
 * Created by pc on 05/02/2017.
 */
public final class JsonUtil {


    public static <T> T fromJson(String json,Class<T> clazz){

        return new GsonBuilder().create().fromJson(json,clazz);

    }

}
