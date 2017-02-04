package com.br.sanson.aplication.domain;

import org.springframework.context.ApplicationEvent;
import org.springframework.util.ObjectUtils;

/**
 * Created by pc on 04/02/2017.
 */
public class Sms extends ApplicationEvent{

    private Mensagem mensagem;

    private Msisdn destination;

    public Sms(Mensagem mensagem, Msisdn destination) {
        super(mensagem);
        if(ObjectUtils.isEmpty(mensagem)||ObjectUtils.isEmpty(destination)){
            throw new IllegalArgumentException("Mensagem ou msisdn não podem ser nulos");
        }
        this.mensagem = mensagem;
        this.destination = destination;
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
