package com.meli.obterdiploma;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.repository.StudentDAO;
import com.meli.obterdiploma.service.ObterDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class ObterDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;
    @InjectMocks
    private ObterDiplomaService service;


    @Test
    public void deveRetornarOValorDaMedia(){
        //setup
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(SubjectDTO.builder().name("Matematica").score(8.0).build());
        subjectDTOList.add(SubjectDTO.builder().name("Geografia").score(7.0).build());
        StudentDTO student = StudentDTO.builder().studentName("Juan").subjects(subjectDTOList).build();
        Mockito.when(this.studentDAO.findById(Mockito.any())).thenReturn(student);

        //execution
        StudentDTO result = this.service.analyzeScores(Mockito.any());

        //check
        Assertions.assertEquals(7.5, result.getAverageScore());
    }

    @Test
    public void deveRetornarMensagemDeParabens(){
        //setup
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(SubjectDTO.builder().name("Matematica").score(10.0).build());
        subjectDTOList.add(SubjectDTO.builder().name("Geografia").score(9.0).build());
        StudentDTO student = StudentDTO.builder().studentName("Juan").subjects(subjectDTOList).build();
        Mockito.when(this.studentDAO.findById(Mockito.any())).thenReturn(student);

        //execution
        StudentDTO result = this.service.analyzeScores(Mockito.any());

        //check
        Assertions.assertEquals("O aluno Juan obteve uma média de 9,5. Parabéns!", result.getMessage());
    }

    @Test
    public void deveRetornarMensagemDeVoceDeveMelhorar(){
        //setup
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(SubjectDTO.builder().name("Matematica").score(9.0).build());
        subjectDTOList.add(SubjectDTO.builder().name("Geografia").score(9.0).build());
        StudentDTO student = StudentDTO.builder().studentName("Juan").subjects(subjectDTOList).build();
        Mockito.when(this.studentDAO.findById(Mockito.any())).thenReturn(student);

        //execution
        StudentDTO result = this.service.analyzeScores(Mockito.any());

        //check
        Assertions.assertEquals("O aluno Juan obteve uma média de 9. Você pode melhorar.", result.getMessage());
    }




}
