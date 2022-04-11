package br.org.mercardolivre.bootcamp.supermarket.controllers;


import br.org.mercardolivre.bootcamp.supermarket.interfaces.CRUD;
import br.org.mercardolivre.bootcamp.supermarket.view.SupermermarketView;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ControllerPrincipal {

    private static ControllerPrincipal instance;


    public static ControllerPrincipal getInstance(){
        if(instance == null){
            instance = new ControllerPrincipal();
        }
        return instance;
    }

    public void start(){
        SupermermarketView.getInstance().start();


    }

    public  CadastroClienteController getControllerCadastro() {
        return CadastroClienteController.getInstance();
    }

    public FaturaController getControllerFatura(){
        return FaturaController.getInstance();
    }

    public ItemController getControllerItens() {
        return ItemController.getInstance();
    }
}
