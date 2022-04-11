package br.mercadolivre.bootcamp;

public interface Printable<T> {

  static void print(Document obj) {
        System.out.println(obj.toString());
    }

}
