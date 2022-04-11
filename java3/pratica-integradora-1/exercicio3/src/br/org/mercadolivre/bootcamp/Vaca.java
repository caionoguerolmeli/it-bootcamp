package br.org.mercadolivre.bootcamp;

import java.nio.charset.CoderMalfunctionError;

public class Vaca extends Animal{
    public static final String NAME = "Vaca";
    public Vaca() {
    }

    @Override
    public void comer() {
        this.comerPasto();
    }

    @Override
    public void emitirSom() {
        System.out.println("Vaca emitiu som: mu");
    }

    private void comerPasto(){
        System.out.println("Vaca comeu pasto");
    }
}
