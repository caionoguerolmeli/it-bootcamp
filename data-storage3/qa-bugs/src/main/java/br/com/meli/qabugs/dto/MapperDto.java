package br.com.meli.qabugs.dto;

import br.com.meli.qabugs.model.TestCase;

import java.time.LocalDate;

public class MapperDto {

    public static TestCase requestDTOtoModel(TestRequestDto testRequestDto){
       return TestCase.builder().tested(testRequestDto.getTested()).description(testRequestDto.getDescription())
                .numberOfTries(testRequestDto.getNumberOfTries()).passed(testRequestDto.getPassed()).build();
    }

    public static TestResponseDto modelTOResponseDto(TestCase testCase){
        return TestResponseDto.builder().lastUpdate(testCase.getLastUpdate()).id(testCase.getId())
                .tested(testCase.getTested()).numberOfTries(testCase.getNumberOfTries())
                .passed(testCase.getPassed()).description(testCase.getDescription()).build();
    }

}
