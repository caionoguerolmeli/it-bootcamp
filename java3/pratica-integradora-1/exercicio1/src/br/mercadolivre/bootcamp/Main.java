package br.mercadolivre.bootcamp;

import java.awt.event.TextEvent;

public class Main {
    public static void main(String[] args) {

        Executivo executivo = new Executivo();
        Cobrador cobrador = new Cobrador();
        Basico basico = new Basico();

        System.out.println("\n Transacoes executivo");
        executivo.deposito();
        executivo.transferencia();
        System.out.println("\n Transacoes basico");
        basico.consultaSaldo();
        basico.pagaServico();
        basico.realizaSaque();
        System.out.println("\n Transacoes cobrador");
        cobrador.consultaSaldo();
        cobrador.realizaSaque();

    }
}
