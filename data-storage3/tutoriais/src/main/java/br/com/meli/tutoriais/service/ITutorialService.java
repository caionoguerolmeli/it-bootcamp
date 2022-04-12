package br.com.meli.tutoriais.service;

import br.com.meli.tutoriais.model.Tutorial;

import java.util.List;

public interface ITutorialService {

    Tutorial save(Tutorial tutorial);
    Tutorial findById(Long id);
    List<Tutorial> findAll();
    List<Tutorial> findAllbyPublished();
    List<Tutorial>  findAllTitleContains(String string);
    void delete(Long id);
    void deleteAll();


}
