package br.mercadolivre.bootcamp;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Pessoa Teste", 18, "07789651904");
        ArrayList<String> habilidades = new ArrayList<>();
        habilidades.add("Java");
        habilidades.add("Javascript");
        habilidades.add("python");
        habilidades.add("go");
        Curriculo curriculo = new Curriculo(pessoa,habilidades);
        Livro livro = new Livro("xxxxxxxxaaaaavvvvvv", 1, "Juquinha", "Joaozinho");
        Relatorio relatorio = new Relatorio("AAAXAVSAScvsdhfusidahfalcda", 1, "Pedrinho", "Mariazinah");
        Printable.print(livro);
        Printable.print(curriculo);
        Printable.print(relatorio);
    }


}
