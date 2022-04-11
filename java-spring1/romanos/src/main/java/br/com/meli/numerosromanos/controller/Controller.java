package br.com.meli.numerosromanos.controller;

import br.com.meli.numerosromanos.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    Service service;
    public Controller() {
        service = new Service();
    }

    @GetMapping("converte")
    @ResponseBody
    public String converteParaRomanos(@RequestParam Integer numero) {
        return this.service.converteParaRomanos(numero);
    }

}
