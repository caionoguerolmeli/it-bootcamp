package br.org.mercardolivre.bootcamp.supermarket.controllers;

import br.org.mercardolivre.bootcamp.supermarket.entities.Item;
import br.org.mercardolivre.bootcamp.supermarket.interfaces.CRUD;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ItemController implements CRUD<List<Item>, Item> {

    private static ItemController instance;
    private List<Item> itens = new ArrayList<>();
    public ItemController() {
        itens.add(Item.builder().nome("Batata").codigo("1").custoUnitario(BigDecimal.valueOf(2.99)).build());
        itens.add(Item.builder().nome("Macarrao").codigo("2").custoUnitario(BigDecimal.valueOf(3.99)).build());
        itens.add(Item.builder().nome("Cebola").codigo("1").custoUnitario(BigDecimal.valueOf(4.79)).build());
        itens.add(Item.builder().nome("Alface").codigo("1").custoUnitario(BigDecimal.valueOf(1.99)).build());


    }

    public static ItemController getInstance() {
        if(instance == null){
            instance = new ItemController();
        }
        return instance;
    }

    @Override
    public boolean create(Item object) {
        return false;
    }

    @Override
    public List<Item> read() {
        return this.itens;
    }

    @Override
    public List<Item> read(String object) {
        return itens.stream().filter((x) -> x.getCodigo().equals(object)).collect(Collectors.toList());
    }

    @Override
    public void update(Item object) {

    }

    @Override
    public boolean delete(String object) {
        return itens.removeIf((c) -> c.getCodigo().equals(object));
    }
}
