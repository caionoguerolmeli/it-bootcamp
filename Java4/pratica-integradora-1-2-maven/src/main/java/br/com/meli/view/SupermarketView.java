package br.com.meli.view;

import br.com.meli.controllers.ControllerPrincipal;
import br.com.meli.interfaces.View;
import br.com.meli.utils.ValidateUtils;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@NoArgsConstructor
public class SupermarketView implements View {

    private static SupermarketView instance;
    private static String option;


    public static SupermarketView getInstance(){
        if(instance == null){
            instance = new SupermarketView();
        }
        return instance;
    }

    public  void start() {
        this.showMenu();
    }

    private  void showMenu() {
        int optionInt = -1;
        Scanner s = new Scanner(System.in);

        System.out.println("----Supermercado O Economico----\n");
        System.out.println("Selecione uma das opcoes abaixo: ");
        System.out.println("1 - Cadastro de Clientes");
        System.out.println("0 - Sair");
        option = s.next();
        if(ValidateUtils.isNumber(option)){
            optionInt = Integer.valueOf(option);
            switch(optionInt){
                case 1:
                    showMenuCadastro();
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("\nOpcao invalida\n");
                    this.voltarAoMenu();
            }
        }else{
            System.out.println("\nOpcao invalida\n");
            this.voltarAoMenu();
        }



    }

    private  void showMenuCadastro() {
        ControllerPrincipal.getInstance().getControllerCadastro().getView().showMenu();
    }

    @Override
    public void voltarAoMenu() {
        this.showMenu();
    }
}

