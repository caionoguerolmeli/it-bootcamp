package br.com.meli.jewelry.service;


import br.com.meli.jewelry.exception.JewelNotFoundException;
import br.com.meli.jewelry.model.Jewel;
import br.com.meli.jewelry.repository.JewelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryService implements IJewelService{

//    @Autowired
//    JewelRepository repository;
    private final JewelRepository repository;

    public JewelryService(JewelRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Jewel save(Jewel jewel) {
        return repository.save(jewel);
    }

    @Override
    @Transactional(readOnly = true)
    public Jewel findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new JewelNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jewel> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Jewel jewel = repository.findById(id).orElseThrow(() -> new JewelNotFoundException(id));
        this.repository.delete(jewel);
    }
}
