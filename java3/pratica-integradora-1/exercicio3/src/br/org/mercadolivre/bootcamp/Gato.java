package br.org.mercadolivre.bootcamp;

public class Gato extends Animal {
    public static final String NAME = "Gato";
    public Gato() {
    }

    @Override
    public void comer() {
       this.comerCarne();
    }

    @Override
    public void emitirSom() {
        System.out.println("Gato emitiu som: miau");
    }

    private void comerCarne() {
        System.out.println("Gato comeu carne!");
    }
}
