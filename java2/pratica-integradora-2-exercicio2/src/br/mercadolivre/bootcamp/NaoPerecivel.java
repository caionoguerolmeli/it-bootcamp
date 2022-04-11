package br.mercadolivre.bootcamp;

import java.math.BigDecimal;

public class NaoPerecivel extends Produto{
    String tipo;

    public NaoPerecivel(String nome, BigDecimal preco, String tipo) {
        super(nome, preco);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NaoPereciveis{" + " nome='" + this.getNome() + '\'' +
                ", preco=" + this.getPreco()+
                "tipo='" + tipo + '\'' +
                '}';
    }
}
