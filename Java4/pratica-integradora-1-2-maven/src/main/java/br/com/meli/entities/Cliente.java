package br.com.meli.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cliente {
    String ID;
    String nome;
    String sobrenome;

    @Override
    public String toString() {
        return "Cliente:" +
                "ID='" + ID + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'';
    }
}