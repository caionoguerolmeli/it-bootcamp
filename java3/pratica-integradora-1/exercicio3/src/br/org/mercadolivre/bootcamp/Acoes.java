package br.org.mercadolivre.bootcamp;

public interface Acoes<T>{
    static void comerAnimal(Animal obj){
        obj.comer();
    }

    static void emitirSomAnimal(Animal obj){
        obj.emitirSom();
    }

}
