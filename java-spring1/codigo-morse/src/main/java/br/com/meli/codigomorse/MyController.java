package br.com.meli.codigomorse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    MorseService service;

    public MyController() {
        service = new MorseService();
    }

    @GetMapping("/converteMorse")
    @ResponseBody
    public String converteParaPortugues(@RequestBody String value){
        return this.service.converteParaPortugues(value);
    }
}
