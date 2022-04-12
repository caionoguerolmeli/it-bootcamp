package br.com.meli.qabugs.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TestRequestDto {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
}
