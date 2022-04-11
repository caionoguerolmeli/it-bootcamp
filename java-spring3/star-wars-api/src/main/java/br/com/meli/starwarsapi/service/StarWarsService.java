package br.com.meli.starwarsapi.service;

import br.com.meli.starwarsapi.dto.CharacterDTO;
import br.com.meli.starwarsapi.entities.Character;
import br.com.meli.starwarsapi.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StarWarsService {

    @Autowired
    private CharacterRepository repository;
    public List<Character> findListCharacters(String name) {
       List<Character> listRepository = this.repository.read();
    }
}
