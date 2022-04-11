package br.org.mercadolivre.bootcamp;

public class Cachorro extends Animal {

    public Cachorro() {
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void emitirSom() {
        System.out.println("Cachorro emitiu som: auau");
    }

    public static String getNAME() {
        return NAME;
    }

    private void comerCarne() {
        System.out.println("Cachorro comeu carne!");
    }
}
