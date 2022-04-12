package br.com.meli.tutoriais.exception;

public class TutorialNotFoundException extends RuntimeException{
    public TutorialNotFoundException(Long id){
        super("Tutorial id"+id+"not found");
    }
}
