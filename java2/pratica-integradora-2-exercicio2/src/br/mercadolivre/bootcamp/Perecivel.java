package br.mercadolivre.bootcamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Perecivel extends Produto {
    int diasParaVencer;

    public Perecivel(String nome, BigDecimal preco, int diasParaVencer) {
        super(nome, preco);
        this.diasParaVencer = diasParaVencer;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public BigDecimal calcular(BigDecimal quantidadeDeProdutos) {
        switch (this.diasParaVencer){
            case 1:
                return super.calcular(quantidadeDeProdutos).divide(BigDecimal.valueOf(4),2, RoundingMode.HALF_UP);
            case 2:
                BigDecimal divisor = new BigDecimal(3);
                return super.calcular(quantidadeDeProdutos).divide(BigDecimal.valueOf(3),2, RoundingMode.HALF_UP);
            case 3:
                return super.calcular(quantidadeDeProdutos).divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP);
            default:
                return super.calcular(quantidadeDeProdutos);
        }
    }

    @Override
    public String toString() {
        return "Pereciveis{" + " nome='" + this.getNome() + '\'' +
                ", preco=" + this.getPreco() +
                "diasParaVencer=" + diasParaVencer +
                '}';
    }
}
