package br.com.meli.tutoriais.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TutorialResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean published;

}
