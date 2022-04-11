package br.com.meli.sports.DTO;

import br.com.meli.sports.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class PersonDTO {
    String name;
    String surname;
    SportDTO sport;

    public static List<PersonDTO> convertToDTO(List<Person> persons){
        return persons.stream().map(p-> new PersonDTO(p.getName(),p.getSurname(), SportDTO.convertToDTO(p.getSport()))).collect(Collectors.toList());
    }
}
