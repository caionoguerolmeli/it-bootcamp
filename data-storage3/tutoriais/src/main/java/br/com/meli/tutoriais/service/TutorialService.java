package br.com.meli.tutoriais.service;

import br.com.meli.tutoriais.exception.TutorialNotFoundException;
import br.com.meli.tutoriais.model.Tutorial;
import br.com.meli.tutoriais.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TutorialService implements ITutorialService{

    @Autowired
    IRepository repository;

    @Override
    public Tutorial save(Tutorial tutorial) {
        return this.repository.save(tutorial);
    }

    @Override
    public Tutorial findById(Long id) {
        return this.repository.findById(id).orElseThrow(()-> new TutorialNotFoundException(id));
    }

    @Override
    public List<Tutorial> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Tutorial> findAllbyPublished() {
        return this.repository.findByPublished(true);
    }

    @Override
    public List<Tutorial> findAllTitleContains(String string) {
        return this.repository.findByTitleContains(string);
    }

    @Override
    public void delete(Long id) {
        Tutorial tutorial = this.findById(id);
        this.repository.delete(tutorial);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }
}
