package com.br.sanson.domain;

import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * Created by pc on 04/02/2017.
 */
public class Sms {

    private Mensagem mensagem;

    private Msisdn destination;

    private Date registrado;

    public Sms(Mensagem mensagem, Msisdn destination) {
        if(ObjectUtils.isEmpty(mensagem)||ObjectUtils.isEmpty(destination)){
            throw new IllegalArgumentException("Mensagem ou msisdn não podem ser nulos");
        }
        this.mensagem = mensagem;
        this.destination = destination;
        this.registrado = new Date();
    }

    public Mensagem mensagem(){
        return mensagem;
    }

    public Msisdn destination(){
        return destination;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "mensagem=" + mensagem +
                ", destination=" + destination +
                '}';
    }
}
