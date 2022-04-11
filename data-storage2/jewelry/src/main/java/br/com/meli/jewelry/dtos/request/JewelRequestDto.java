package br.com.meli.jewelry.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JewelRequestDto {

    String material;
    Double weight;
    Integer carat;

}
