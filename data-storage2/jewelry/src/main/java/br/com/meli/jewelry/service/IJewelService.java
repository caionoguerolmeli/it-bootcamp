package br.com.meli.jewelry.service;

import br.com.meli.jewelry.model.Jewel;

import java.util.List;
import java.util.Optional;

public interface IJewelService {

    Jewel save(Jewel jewel);
    Jewel findById(Long id);
    List<Jewel> findAll();
    void delete(Long id);


}
