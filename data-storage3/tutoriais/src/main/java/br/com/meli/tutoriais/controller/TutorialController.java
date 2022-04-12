package br.com.meli.tutoriais.controller;

import br.com.meli.tutoriais.dto.MapperDTO;
import br.com.meli.tutoriais.dto.TutorialRequestDTO;
import br.com.meli.tutoriais.dto.TutorialResponseDTO;
import br.com.meli.tutoriais.model.Tutorial;
import br.com.meli.tutoriais.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    TutorialService service;

    @PostMapping()
    public ResponseEntity<TutorialResponseDTO> create(@RequestBody TutorialRequestDTO requestDTO){
        Tutorial tutorial = MapperDTO.requestToModel(requestDTO);
        return ResponseEntity.ok().body(MapperDTO.modelToResponse(this.service.save(tutorial)));
    }


    @GetMapping()
    public ResponseEntity<List<TutorialResponseDTO>> findAll(@RequestParam (required = false, value = "title") String title){
        if(title!=null){
            return ResponseEntity.ok().body(this.service.findAllTitleContains(title).stream().map((t)-> MapperDTO.modelToResponse(t)).collect(Collectors.toList()));
        }
        return ResponseEntity.ok().body(this.service.findAll().stream().map((t)-> MapperDTO.modelToResponse(t)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorialResponseDTO> findById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok().body(MapperDTO.modelToResponse(this.service.findById(id)));
    }

    @GetMapping("/published")
    public ResponseEntity<List<TutorialResponseDTO>> findAllByPublished(){
        return ResponseEntity.ok().body(this.service.findAllbyPublished().stream().map((t)-> MapperDTO.modelToResponse(t)).collect(Collectors.toList()));
    }



    @PutMapping("/{id}")
    public ResponseEntity<TutorialResponseDTO> update(@PathVariable(name="id") Long id, @RequestBody TutorialRequestDTO requestDTO){
        this.service.findById(id);
        Tutorial tutorial = MapperDTO.requestToModel(requestDTO);
        tutorial.setId(id);
        return ResponseEntity.ok().body(MapperDTO.modelToResponse(this.service.save(tutorial)));
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteAll(){
        this.service.deleteAll();
        return ResponseEntity.ok().body("All tutorials are excluded");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){

        this.service.delete(id);
        return ResponseEntity.ok().body("Tutorial id"+id+" excluded");
    }




}
