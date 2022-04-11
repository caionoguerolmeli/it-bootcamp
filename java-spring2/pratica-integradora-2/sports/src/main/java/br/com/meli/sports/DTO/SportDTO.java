package br.com.meli.sports.DTO;

import br.com.meli.sports.entities.Sport;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class SportDTO {
    String name;

    public static SportDTO convertToDTO(Sport sport) {
        return new SportDTO(sport.getName());
    }

    public static List<SportDTO> convertDTO(List<Sport> sports){
        return sports.stream().map(s->new SportDTO(s.getName())).collect(Collectors.toList());
    }
}
