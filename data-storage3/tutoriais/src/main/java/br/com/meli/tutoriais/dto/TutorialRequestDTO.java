package br.com.meli.tutoriais.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TutorialRequestDTO {
    private String title;
    private String description;
    private Boolean published;
}
