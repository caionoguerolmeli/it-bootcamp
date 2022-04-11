package br.com.meli.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Item {
    String codigo;
    String nome;
    int quantidade = 0;
    BigDecimal custoUnitario;

}