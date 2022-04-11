package br.com.meli.sports.controller;

import br.com.meli.sports.DTO.PersonDTO;
import br.com.meli.sports.DTO.SportDTO;
import br.com.meli.sports.service.SportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SportController {

    private final SportService service;


    @GetMapping("/findsports")
    public ResponseEntity<List<SportDTO>> findSports(){
        return ResponseEntity.ok(service.findSports());
    }

    @GetMapping("/findsport/{name}")
    public ResponseEntity<SportDTO>findSportByName(@PathVariable(name="name") String name){
        return ResponseEntity.ok(service.findSportByName(name));
    }

    @GetMapping("/findsportspersons")
    public ResponseEntity<List<PersonDTO>>findSportsPersons(){
        return ResponseEntity.ok(service.findSportsPersons());
    }
}
