package br.com.meli.jewelry.controller;


import br.com.meli.jewelry.dtos.mapper.MapperDTO;
import br.com.meli.jewelry.dtos.request.JewelRequestDto;
import br.com.meli.jewelry.dtos.response.JewelResponseDto;
import br.com.meli.jewelry.model.Jewel;
import br.com.meli.jewelry.service.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {


    @Autowired
    JewelryService jewelryService;

    @PostMapping("/jewel/insert")
    public ResponseEntity<JewelResponseDto> create(@RequestBody JewelRequestDto jewelRequestDto, UriComponentsBuilder uriBuilder) {
        Jewel jewelToCreate = MapperDTO.jewelRequestDtoToJewel(jewelRequestDto);
        Jewel jewel = this.jewelryService.save(jewelToCreate);
        URI uri = uriBuilder
                .path("{id}")
                .buildAndExpand(jewel.getId())
                .toUri();

        return ResponseEntity.created(uri).body(MapperDTO.jewelToJewelResponseDTO(jewel));
    }


    @GetMapping("/jewels")
    public ResponseEntity<List<JewelResponseDto>> findAll(){
        List<JewelResponseDto> jewels = this.jewelryService.findAll().stream()
                .map((j)->MapperDTO.jewelToJewelResponseDTO(j)).collect(Collectors.toList());
        return ResponseEntity.ok().body(jewels);
    }

    @DeleteMapping("/jewel/delete")
    public ResponseEntity<String> delete(@RequestParam(value = "delete") Long id){
        this.jewelryService.delete(id);
        return ResponseEntity.ok().body("Jewel deleted");
    }

    @PutMapping("/jewel/update")
    public ResponseEntity<JewelResponseDto> update(@RequestBody JewelRequestDto jewelRequestDto,
                                                   @RequestParam(value = "id") Long id){
        this.jewelryService.findById(id);
        Jewel jewel = MapperDTO.jewelRequestDtoToJewel(jewelRequestDto);
        jewel.setId(id);
        return ResponseEntity.ok().body(MapperDTO.jewelToJewelResponseDTO(this.jewelryService.save(jewel)));
    }

}
