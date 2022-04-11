package br.com.meli.sports.service;

import br.com.meli.sports.DTO.PersonDTO;
import br.com.meli.sports.DTO.SportDTO;
import br.com.meli.sports.Level;
import br.com.meli.sports.entities.Person;
import br.com.meli.sports.entities.Sport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class SportService {

    private static List<Person> persons = new ArrayList<>();
    private static List<Sport> sports = new ArrayList<>();
     static{

         Sport sport1 = new Sport("Basketball", "amateur");
         Sport sport2 = new Sport("Rugby", "beginner");
         Sport sport3 = new Sport("Soccer", "professional");
         Collections.addAll(sports, sport1,sport2,sport3);
         Collections.addAll(persons, new Person("Maria", "Silva",22, sport1),
                 new Person("Joao", "Souza",22, sport1),
                 new Person("Luiza", "Fonseca",22, sport2),
                 new Person("Lucas", "Santos",22, sport3));
     }

    public List<SportDTO> findSports(){
         return SportDTO.convertDTO(sports);
    }


    public SportDTO  findSportByName(String name) {
         return SportDTO.convertToDTO(sports.stream().filter(sport -> sport.getName().equalsIgnoreCase(name)).findAny().get());
    }

    public List<PersonDTO> findSportsPersons() {
        return PersonDTO.convertToDTO(persons);
    }
}
