package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ]+", message = "O nome do aluno deve começar com letra maiúscula.")
    @Size(max = 50, message = "O comprimento do nome do aluno não pode exceder 50 caracteres.")
    @NotBlank(message = "O nome do aluno nao pode ficar vazio")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "A lista nao pode estar vazia")
    List<@Valid SubjectDTO> subjects;
}
