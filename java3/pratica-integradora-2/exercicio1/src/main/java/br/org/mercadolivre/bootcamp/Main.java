package br.org.mercadolivre.bootcamp;

import br.org.mercadolivre.bootcamp.entities.Garagem;
import br.org.mercadolivre.bootcamp.entities.Veiculo;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Veiculo> veiculoList = new ArrayList<>();

        Veiculo veiculo1 = new Veiculo("Ford", "Fiesta", BigDecimal.valueOf(1000));
        Veiculo veiculo2 = new Veiculo("Ford", "Focus", BigDecimal.valueOf(1200));
        Veiculo veiculo3 = new Veiculo("Ford", "Explorer", BigDecimal.valueOf(2500));
        Veiculo veiculo4 = new Veiculo("Fiat", "Uno", BigDecimal.valueOf(500));
        Veiculo veiculo5 = new Veiculo("Fiat", "Cronos", BigDecimal.valueOf(1000));
        Veiculo veiculo6 = new Veiculo("Fiat", "Torino", BigDecimal.valueOf(1250));
        Veiculo veiculo7 = new Veiculo("Chevrolet", "Aveo", BigDecimal.valueOf(1250));
        Veiculo veiculo8 = new Veiculo("Chevrolet", "Spin", BigDecimal.valueOf(2500));
        Veiculo veiculo9 = new Veiculo("Toyota", "Corola", BigDecimal.valueOf(1200));
        Veiculo veiculo10 = new Veiculo("Toyota", "Fortuner", BigDecimal.valueOf(3000));
        Veiculo veiculo11 = new Veiculo("Renault", "Logan", BigDecimal.valueOf(950));

        veiculoList.add(veiculo1);
        veiculoList.add(veiculo2);
        veiculoList.add(veiculo3);
        veiculoList.add(veiculo4);
        veiculoList.add(veiculo5);
        veiculoList.add(veiculo6);
        veiculoList.add(veiculo7);
        veiculoList.add(veiculo8);
        veiculoList.add(veiculo9);
        veiculoList.add(veiculo10);
        veiculoList.add(veiculo11);


        Garagem garagem = new Garagem("G01", veiculoList);

        System.out.println("-----Lista ordenada por preco-----");
        garagem.getVeiculoList().stream().sorted((x,y) -> x.getPreco().compareTo(y.getPreco()))
                            .forEach(System.out::println);

        System.out.println("\n-----Lista ordenada por marca-----");
        garagem.getVeiculoList().stream().sorted((x,y)-> x.getMarca().compareTo(y.getMarca()))
                            .forEach(System.out::println);

        System.out.println("\n-----Lista com preco menor que 1000-----");
        garagem.getVeiculoList().stream().filter((x)-> x.getPreco().compareTo(BigDecimal.valueOf(1000))<0)
                .forEach(System.out::println);


        System.out.println("\n-----Lista com preco maior igual a 1000-----");
        garagem.getVeiculoList().stream().filter((x)-> x.getPreco().compareTo(BigDecimal.valueOf(1000))>=0)
                .forEach(System.out::println);


        double average = garagem.getVeiculoList().stream()
                .map(vehicle -> vehicle.getPreco())
                .mapToDouble(x -> x.doubleValue())
                .average().getAsDouble();

        DecimalFormat decimalFormatter = new DecimalFormat("0.00");
        System.out.println("\nMedia de preco:  "+ (decimalFormatter.format(average)));

    }


}
