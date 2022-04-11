package br.com.meli.jewelry.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class JewelNotFoundException extends RuntimeException{
    private HttpStatus httpStatus;
    public JewelNotFoundException(Long id){
        super("Jewel not found");
        httpStatus  = HttpStatus.BAD_REQUEST;
    }

}
