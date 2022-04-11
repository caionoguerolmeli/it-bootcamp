package br.mercadolivre.bootcamp;

import java.math.BigDecimal;

public class Distribuidora {
    public static void main(String[] args) {
        Produto[] produtos = new Produto[7];

        NaoPerecivel naoPerecivelA = new NaoPerecivel("isqueiro", BigDecimal.valueOf(5.32), "inflamavel");
        NaoPerecivel naoPerecivelB = new NaoPerecivel("detergente", BigDecimal.valueOf(3.33), "naoInflamavel");
        Perecivel perecivelA = new Perecivel("laranja", BigDecimal.valueOf(2.50), 1);
        Perecivel perecivelB = new Perecivel("batata", BigDecimal.valueOf(1.0), 2);
        Perecivel perecivelC = new Perecivel("carne", BigDecimal.valueOf(30.0), 3);
        Perecivel perecivelD = new Perecivel("peixe", BigDecimal.valueOf(20.0), 4);
        Produto produto = new Produto("celular", BigDecimal.valueOf(300));

        produtos[0] = naoPerecivelA;
        produtos[1] = naoPerecivelB;
        produtos[2] = perecivelA;
        produtos[3] = perecivelB;
        produtos[4] = perecivelC;
        produtos[5] = perecivelD;
        produtos[6] = produto;

        for (int i = 0; i < produtos.length; i++) {
            System.out.println("Nome: " + produtos[i].getNome() + "Valor total: " + produtos[i].calcular(BigDecimal.valueOf(10)));
        }
    }
}
