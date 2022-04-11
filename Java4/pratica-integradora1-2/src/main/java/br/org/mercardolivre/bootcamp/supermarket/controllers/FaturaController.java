package br.org.mercardolivre.bootcamp.supermarket.controllers;

import br.org.mercardolivre.bootcamp.supermarket.interfaces.CRUD;
import br.org.mercardolivre.bootcamp.supermarket.entities.Fatura;
import br.org.mercardolivre.bootcamp.supermarket.view.FaturaView;
import br.org.mercardolivre.bootcamp.supermarket.view.SupermermarketView;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class FaturaController implements CRUD<List<Fatura>,Fatura> {


    private static FaturaController instance;
    private static String option;


    public static FaturaController getInstance(){
        if(instance == null){
            instance = new FaturaController();
        }
        return instance;
    }

    @Override
    public boolean create(Fatura object) {
        return false;
    }

    @Override
    public List<Fatura> read() {
        return null;
    }

    @Override
    public List<Fatura> read(String object) {
        return null;
    }

    @Override
    public void update(Fatura object) {

    }

    @Override
    public boolean delete(String object) {
        return false;
    }

    public FaturaView getView(){
        return FaturaView.getInstance();
    }
}
