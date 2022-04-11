package br.com.meli.jewelry.dtos.mapper;


import br.com.meli.jewelry.dtos.request.JewelRequestDto;
import br.com.meli.jewelry.dtos.response.JewelResponseDto;
import br.com.meli.jewelry.model.Jewel;

public class MapperDTO {

    public static Jewel jewelRequestDtoToJewel(JewelRequestDto jewelRequestDto){
        return Jewel.builder().material(jewelRequestDto.getMaterial())
                .carat(jewelRequestDto.getCarat()).weight(jewelRequestDto.getWeight()).build();
    }

    public static JewelResponseDto jewelToJewelResponseDTO(Jewel jewel){
       return JewelResponseDto.builder().id(jewel.getId()).weight(jewel.getWeight()).carat(jewel.getCarat())
               .material(jewel.getMaterial()).build();
    }

}
