package br.mercadolivre.bootcamp;

public class Basico extends Cliente {

    public void consultaSaldo() {
        System.out.println("O seu saldo é de R$" + this.getSaldo());
    }

    public void realizaSaque() {
        System.out.println("Realizando saque...");
        super.acertoTransacao();
    }

    public void pagaServico() {
        System.out.println("Pagando servico...");
        super.acertoTransacao();
    }




}
