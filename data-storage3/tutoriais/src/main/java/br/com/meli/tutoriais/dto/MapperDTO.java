package br.com.meli.tutoriais.dto;

import br.com.meli.tutoriais.model.Tutorial;

public class MapperDTO {

    public static Tutorial requestToModel(TutorialRequestDTO requestDTO){
        return Tutorial.builder().description(requestDTO.getDescription()).title(requestDTO.getTitle()).published(requestDTO.getPublished()).build();
    }

    public static TutorialResponseDTO modelToResponse(Tutorial tutorial){
        return TutorialResponseDTO.builder().id(tutorial.getId()).published(tutorial.getPublished())
                .title(tutorial.getTitle()).description(tutorial.getDescription()).build();
    }

}
