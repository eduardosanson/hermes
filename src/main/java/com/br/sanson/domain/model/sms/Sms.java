package com.br.sanson.domain.model.sms;

import com.br.sanson.domain.shared.Mensagem;
import com.br.sanson.domain.shared.Msisdn;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * Created by pc on 04/02/2017.
 */
@Document
public class Sms {

    @Id
    private String id;

    private Mensagem mensagem;

    private Msisdn destination;

    private Date registrado;

    @JsonCreator
    public Sms(Mensagem mensagem, Msisdn destination) {
        if(ObjectUtils.isEmpty(mensagem)||ObjectUtils.isEmpty(destination)){
            throw new IllegalArgumentException("Mensagem e msisdn não podem ser nulos");
        }
        this.mensagem = mensagem;
        this.destination = destination;
        this.registrado = new Date();
    }

    @JsonProperty
    public Mensagem mensagem(){
        return mensagem;
    }

    @JsonProperty
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
