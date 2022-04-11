package br.com.meli.idadepessoa.service;

import org.springframework.stereotype.Service;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class AgeService {
    public Integer calculateAge(Integer month, Integer day, Integer year) {
        
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate date = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(birthDate, date);
    }
}
