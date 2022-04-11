package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull
    @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ]+", message = "O nome do aluno deve começar com letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome do assunto não pode exceder 30 caracteres.")
    @NotBlank(message = "O nome do aluno nao pode ficar vazio")
    String name;
    @NotNull(message = "A nota nao pode estar vazia")
    @DecimalMax(value = "10.0", message = "A nota máxima da disciplina é de 10 pontos.")
    @DecimalMin(value = "0.0", message = "A nota mínima para a disciplina é de 0 pts.")
    Double score;
}
