package br.mercadolivre.bootcamp;

import java.util.ArrayList;

public class Curriculo extends Document {
    Pessoa pessoa;
    ArrayList<String> habilidades = new ArrayList<>();


    public Curriculo(Pessoa pessoa, ArrayList<String> habilidades) {
        this.pessoa = pessoa;
        this.habilidades = habilidades;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        String listString = String.join(", ", habilidades);
        return "Curriculo{" +
                "pessoa=" + pessoa +
                ", habilidades=" + listString +
                '}';
    }
}
