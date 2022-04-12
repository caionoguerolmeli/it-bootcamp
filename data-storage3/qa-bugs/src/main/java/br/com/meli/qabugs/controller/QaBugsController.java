package br.com.meli.qabugs.controller;

import br.com.meli.qabugs.dto.MapperDto;
import br.com.meli.qabugs.dto.TestRequestDto;
import br.com.meli.qabugs.dto.TestResponseDto;
import br.com.meli.qabugs.model.TestCase;
import br.com.meli.qabugs.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/testcases")
public class QaBugsController {

    @Autowired
    TestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<TestResponseDto> create(@RequestBody TestRequestDto requestDto, UriComponentsBuilder uriBuilder){
        TestCase testCase = MapperDto.requestDTOtoModel(requestDto);
        testCase.setLastUpdate(LocalDate.now());
        TestCase testCaseSaved = this.service.save(testCase);
        URI uri = uriBuilder
                .path("{id}")
                .buildAndExpand(testCaseSaved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(MapperDto.modelTOResponseDto(testCaseSaved));
    }

    @GetMapping()
    public ResponseEntity<List<TestResponseDto>> findAll(@RequestParam(required = false, name = "last_update") String date){
        if(date!=null){
            return ResponseEntity.ok().body(service.findByLastUpdate(date)
                    .stream().map(t->MapperDto.modelTOResponseDto(t)).collect(Collectors.toList()));
        }
        return ResponseEntity.ok().body(service.findAll()
                .stream().map(t->MapperDto.modelTOResponseDto(t)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestResponseDto> findById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok().body(MapperDto.modelTOResponseDto(this.service.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestResponseDto> update(@PathVariable(name="id") Long id,
                                                  @RequestBody TestRequestDto requestDto){
        this.service.findById(id);
        TestCase testToUpdate = MapperDto.requestDTOtoModel(requestDto);
        testToUpdate.setId(id);
        testToUpdate.setLastUpdate(LocalDate.now());
        return ResponseEntity.ok().body(MapperDto.modelTOResponseDto(this.service.save(testToUpdate)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        this.service.delete(id);
        return ResponseEntity.ok().body("Test deleted");
    }



}
