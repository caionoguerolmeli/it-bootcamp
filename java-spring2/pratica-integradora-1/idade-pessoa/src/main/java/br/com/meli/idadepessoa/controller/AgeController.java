package br.com.meli.idadepessoa.controller;

import br.com.meli.idadepessoa.service.AgeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping
public class AgeController {

    private final AgeService service;

    @GetMapping("/{m}/{d}/{y}")
    public ResponseEntity<?> calculateAge(@PathVariable(name = "m") Integer month,
                                          @PathVariable(name = "d") Integer day,
                                          @PathVariable(name = "y") Integer year){
        return ResponseEntity.ok(service.calculateAge(month,day,year));
    }


}
