package br.com.meli.starwarsapi.controller;

import br.com.meli.starwarsapi.dto.CharacterDTO;
import br.com.meli.starwarsapi.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

    @Autowired
    private StarWarsService service;

    @GetMapping("/starwars/{name}")
    public ResponseEntity<List<CharacterDTO>> findListCharacters(@PathVariable(name="name")String name){
        return ResponseEntity.ok(service.findListCharacters(name));
    }
}
