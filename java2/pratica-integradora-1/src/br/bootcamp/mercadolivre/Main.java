package br.bootcamp.mercadolivre;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoaA = new Pessoa();
        Pessoa pessoaB = new Pessoa("Joao", 22, "1234", 100, 1.78);

        System.out.println("Nome: " + pessoaB.getNome() + "\nIdade: "+ pessoaB.getIdade() + "\nID: " + pessoaB.getID() + "\nPeso (kg): "
                + pessoaB.getPeso() + "\nIdade (m): "+pessoaB.getAltura() + "\nIMC: "+ pessoaA.calcularIMC(pessoaB.getPeso(), pessoaB.getAltura())
                + "\nEh maior de idade: " + pessoaB.ehMaiorIdade(pessoaB.getIdade()));
    }
}
