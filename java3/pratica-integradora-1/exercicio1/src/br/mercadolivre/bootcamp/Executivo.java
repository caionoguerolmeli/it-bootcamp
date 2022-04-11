package br.mercadolivre.bootcamp;

public class Executivo extends Cliente{

    public void deposito(){
        System.out.println("Fazendo deposito...");
        super.acertoTransacao();
    }
    public void transferencia(){
        System.out.println("Fazendo transferencia...");
        super.acertoTransacao();
    }

}
