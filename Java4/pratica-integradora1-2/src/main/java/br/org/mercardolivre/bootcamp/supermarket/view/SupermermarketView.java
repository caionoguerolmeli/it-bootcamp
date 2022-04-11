package br.org.mercardolivre.bootcamp.supermarket.view;


import br.org.mercardolivre.bootcamp.supermarket.controllers.ControllerPrincipal;
import br.org.mercardolivre.bootcamp.supermarket.interfaces.View;
import br.org.mercardolivre.bootcamp.supermarket.utils.ValidateUtils;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@NoArgsConstructor
public class SupermermarketView implements View {

    private static SupermermarketView view;
    private static String option;


    public static SupermermarketView getInstance(){
        if(view == null){
            view = new SupermermarketView();
        }
        return view;
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
