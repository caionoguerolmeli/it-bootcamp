package br.com.meli.jewelry.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JewelResponseDto {

    Long id;
    String material;
    Double weight;
    Integer carat;
}
