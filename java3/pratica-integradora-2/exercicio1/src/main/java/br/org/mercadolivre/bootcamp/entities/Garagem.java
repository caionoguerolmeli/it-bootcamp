package br.org.mercadolivre.bootcamp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
public class Garagem {
    String id;
    List<Veiculo> veiculoList = new ArrayList<>();

}
