package br.mercadolivre.bootcamp;

import java.math.BigDecimal;
import java.util.Random;

public abstract class Cliente implements Transacao {
    BigDecimal saldo;
    Random rd = new Random();

    public Cliente() {
        this.saldo = BigDecimal.valueOf(rd.nextInt(1000000));
    }

    @Override
    public void transacaoNaoOk() {
        System.out.println("Transacao falhou!");
    }

    @Override
    public void transacaoOk() {
        System.out.println("Transacao OK!");
    }

    public void acertoTransacao() {
        if (rd.nextBoolean()) {
            this.transacaoOk();
        } else {
            this.transacaoNaoOk();
        }
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
