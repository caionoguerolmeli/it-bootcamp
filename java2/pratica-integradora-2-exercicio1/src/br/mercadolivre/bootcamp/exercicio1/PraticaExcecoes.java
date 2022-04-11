package br.mercadolivre.bootcamp.exercicio1;

public class PraticaExcecoes {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
//        try{ Exercicio 1A
//            double razao = b/a;
//        }catch(ArithmeticException e){
//            System.out.println("Ocorreu um erro!");
//        }
        try {
            double razao = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Não pode ser dividido por zero!");
        }

        System.out.println("Programa finalizado!");

    }
}
