package br.mercadolivre.bootcamp;

public class Cobrador extends Cliente{

    public void consultaSaldo() {
        System.out.println("O seu saldo é de R$" + this.getSaldo());
    }

    public void realizaSaque() {
        System.out.println("Realizando saque...");
        super.acertoTransacao();
    }
}
