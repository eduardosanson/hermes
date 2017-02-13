package com.br.sanson.domain.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by pc on 04/02/2017.
 */
public class Mensagem {

    private String mensagem;

    public Mensagem(String mensagem,String[] params) {
        this.mensagem = MessageFormat
                .format(
                        Optional
                                .ofNullable(mensagem)
                                .orElseThrow(()-> new IllegalArgumentException("Mensagem não pode ser nula")),
                        params);

    }

    @JsonCreator
    public Mensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Mensagem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mensagem mensagem1 = (Mensagem) o;
        return Objects.equals(mensagem, mensagem1.mensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mensagem);
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "value='" + mensagem + '\'' +
                '}';
    }

    @JsonProperty
    public String mensagem(){
        return mensagem;
    }

}
