package br.org.mercardolivre.bootcamp.supermarket.view;

import br.org.mercardolivre.bootcamp.supermarket.controllers.ControllerPrincipal;
import br.org.mercardolivre.bootcamp.supermarket.entities.Cliente;
import br.org.mercardolivre.bootcamp.supermarket.entities.Item;
import br.org.mercardolivre.bootcamp.supermarket.interfaces.View;
import br.org.mercardolivre.bootcamp.supermarket.utils.ValidateUtils;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class FaturaView implements View {

    private static String option;
    private static Scanner s = new Scanner(System.in);
    private static FaturaView instance;

    public static FaturaView getInstance(){
        if(instance == null){
            instance = new FaturaView();
        }
        return instance;
    }

    public void showMenu(){
        int optionInt = -1;

        System.out.print("---- MENU DO CADASTRO ----\n"
                + "1 - Novo Cadastro\n"
                + "2 - Ver Clientes\n"
                + "3 - Remover Cliente\n"
                + "4 - Procurar Cliente\n"
                + "0 - Voltar\n"
                + "--------------------------------\n");
        option = s.next();
        if (ValidateUtils.isNumber(option)) {
            optionInt = Integer.valueOf(option);
            switch (optionInt) {
                case 1:
                    this.createFatura();
                    break;
                case 2:
                    this.getFatura();
                    break;
                case 3:
                    this.removeFatura();
                    break;
                case 4:
                    this.findFatura();
                    break;
                case 0:
                    this.getSupermarketView();
                    break;
                default:
                    System.out.println("\nOpcao invalida\n");
                    this.voltarAoMenu();
            }

        } else {
            System.out.println("\nOpcao invalida\n");
            this.voltarAoMenu();
        }
    }

    private void getSupermarketView() {
        ControllerPrincipal.getInstance().start();
    }

    private void createFatura() {
        Cliente cliente = this.verificarCliente();
        System.out.println("Escolha os itens da lista digitando seu ID");
        List<Item> list = ControllerPrincipal.getInstance().getControllerItens().read();
        

    }

    private Cliente verificarCliente() {
        System.out.println("Informar ID do cliente:");
        String id = s.next();
        if(ControllerPrincipal.getInstance().getControllerCadastro().read(id).isEmpty()){
            ControllerPrincipal.getInstance().getControllerCadastro().getView().createCliente();
        }
        return ControllerPrincipal.getInstance().getControllerCadastro().read(id).get(0);

    }

    private void getFatura() {
    }

    private void removeFatura() {
    }

    private void findFatura() {
    }

    @Override
    public void voltarAoMenu() {

    }
}
