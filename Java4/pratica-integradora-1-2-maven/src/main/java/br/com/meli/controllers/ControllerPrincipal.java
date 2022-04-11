package br.com.meli.controllers;



import br.com.meli.view.SupermarketView;
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
        SupermarketView.getInstance().start();


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
