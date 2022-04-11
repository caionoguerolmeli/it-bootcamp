package br.org.mercardolivre.bootcamp.supermarket;

import br.org.mercardolivre.bootcamp.supermarket.controllers.ControllerPrincipal;
import br.org.mercardolivre.bootcamp.supermarket.view.SupermermarketView;

import static br.org.mercardolivre.bootcamp.supermarket.view.SupermermarketView.*;

public class Main {
    public static void main(String[] args) {
         ControllerPrincipal.getInstance().start();
    }
}
