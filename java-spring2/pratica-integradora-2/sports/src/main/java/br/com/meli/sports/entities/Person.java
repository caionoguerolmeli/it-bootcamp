package br.com.meli.sports.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    String name;
    String surname;
    Integer age;
    Sport sport;
}
