package br.com.meli.jewelry.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="jewels")
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String material;
    Double weight;
    Integer carat;
}
