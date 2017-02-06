package com.br.sanson.domain.shared;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by pc on 04/02/2017.
 */
public class Mensagem {

    private String mensagem;

    public Mensagem(String mensagem) {

        this.mensagem =
        Optional
                .ofNullable(mensagem)
                .orElseThrow(()-> new IllegalArgumentException("Mensagem não pode ser nula"));
    }

    public String asString(){
        return mensagem;
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

}
