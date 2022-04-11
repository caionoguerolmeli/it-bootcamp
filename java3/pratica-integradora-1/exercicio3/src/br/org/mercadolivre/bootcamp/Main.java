package br.org.mercadolivre.bootcamp;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro =new Cachorro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        Acoes.comerAnimal(vaca);
        Acoes.emitirSomAnimal(vaca);
        Acoes.comerAnimal(cachorro);
        Acoes.emitirSomAnimal(cachorro);
        Acoes.comerAnimal(gato);
        Acoes.emitirSomAnimal(gato);
    }
}
