package br.org.mercardolivre.bootcamp.supermarket.controllers;

import br.org.mercardolivre.bootcamp.supermarket.entities.Cliente;
import br.org.mercardolivre.bootcamp.supermarket.interfaces.CRUD;
import br.org.mercardolivre.bootcamp.supermarket.view.CadastroView;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CadastroClienteController implements CRUD<List<Cliente>, Cliente> {
    private static CadastroClienteController instance;
    private List<Cliente> clientes = new ArrayList<Cliente>();


    public static CadastroClienteController getInstance() {
        if (instance == null) {
            instance = new CadastroClienteController();
        }
        return instance;
    }


    @Override
    public boolean create(Cliente cliente) {
        if (this.read(cliente.getID()).isEmpty()) {
            return clientes.add(cliente);
        }
        return false;

    }

    @Override
    public List<Cliente> read() {
        return this.clientes;

    }

    @Override
    public List<Cliente> read(String object) {
        return clientes.stream().filter((x) -> x.getID().equals(object)).collect(Collectors.toList());

    }

    @Override
    public void update(Cliente object) {

    }

    @Override
    public boolean delete(String object) {
        return clientes.removeIf((c) -> c.getID().equals(object));
    }

    public CadastroView getView() {
        return CadastroView.getInstance();
    }

}
