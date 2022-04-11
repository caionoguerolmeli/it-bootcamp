package br.com.meli.view;

import br.com.meli.controllers.ControllerPrincipal;
import br.com.meli.entities.Cliente;
import br.com.meli.interfaces.View;
import br.com.meli.utils.ValidateUtils;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class CadastroView implements View {

    private static CadastroView instance;
    private String option;
    private Scanner s = new Scanner(System.in);



    public static CadastroView getInstance() {
        if (instance == null) {
            instance = new CadastroView();
        }
        return instance;
    }

    public void showMenu() {
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
                    this.createCliente();
                    break;
                case 2:
                    this.getClientes();
                    break;
                case 3:
                    this.removeCliente();
                    break;
                case 4:
                    this.findCliente();
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

    private void findCliente() {
        System.out.println("Insira o id do cliente:");
        List<Cliente> list = ControllerPrincipal.getInstance().getControllerCadastro().read(s.next());
        this.printClientes(list, false);
    }

    private void removeCliente() {
        System.out.println("Insira o ID do cliente que deseja excluir");
        if (ControllerPrincipal.getInstance().getControllerCadastro().delete(s.next())) {
            System.out.println("Cliente removido!\n");
        } else {
            System.out.println("Cliente nao encontrado!\n");
        }
        this.voltarAoMenu();
    }

    private void getClientes() {
        List<Cliente> list = ControllerPrincipal.getInstance().getControllerCadastro().read();
        this.printClientes(list, true);


    }

    public void createCliente() {
        System.out.println("Insira o ID do cliente");
        String ID = s.next();
        System.out.println("Insira o nome do cliente");
        String nome = s.next();
        System.out.println("Insira o sobrenome do cliente");
        String sobrenome = s.next();
        Cliente cliente = Cliente.builder().ID(ID).nome(nome).sobrenome(sobrenome).build();
        if(ControllerPrincipal.getInstance().getControllerCadastro().create(cliente)){
            System.out.println("\nCliente cadastrado com sucesso!\n");
        }else{
            System.out.println("\nCliente nao cadastrado! Este ID ja esta cadastrado\n");
        }

        this.voltarAoMenu();
    }

    private void printClientes(List<Cliente> list, boolean all) {
        if (!list.isEmpty()) {
            list.stream().forEach(System.out::println);
        } else if(all == false){
            System.out.println("\nCliente nao encontrado!\n");
        }else{
            System.out.println("\nNao ha clientes cadastrados\n");

        }
        this.voltarAoMenu();
    }

    @Override
    public void voltarAoMenu() {
        this.showMenu();
    }


}

