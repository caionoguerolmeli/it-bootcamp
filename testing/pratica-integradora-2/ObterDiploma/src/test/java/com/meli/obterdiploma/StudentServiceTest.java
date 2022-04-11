package com.meli.obterdiploma;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.repository.IStudentRepository;
import com.meli.obterdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService service;

    @Test
    public void deveCriarStudentDTO(){
        //setup
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(SubjectDTO.builder().name("Matematica").score(8.0).build());
        subjectDTOList.add(SubjectDTO.builder().name("Geografia").score(7.0).build());
        StudentDTO student = StudentDTO.builder().studentName("Juan").subjects(subjectDTOList).build();
        ArgumentCaptor<StudentDTO> valueCapture = ArgumentCaptor.forClass(StudentDTO.class);
        Mockito.doNothing().when(this.studentDAO).save(valueCapture.capture());
        //execute
        this.service.create(student);
        //check
        Assertions.assertEquals("Juan", valueCapture.getValue().getStudentName());

    }

    @Test
    public void deveLerStudentDTO(){
        //setup
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(SubjectDTO.builder().name("Matematica").score(8.0).build());
        subjectDTOList.add(SubjectDTO.builder().name("Geografia").score(7.0).build());
        StudentDTO student = StudentDTO.builder().studentName("Juan").subjects(subjectDTOList).build();
        Mockito.when(this.studentDAO.findById(Mockito.any())).thenReturn(student);
        //execute
        StudentDTO result = this.service.read(Mockito.any());
        //check
        Assertions.assertEquals("Juan", result.getStudentName());

    }

    @Test
    public void deveFazerUpdateDeStudentDao(){
        //setup
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(SubjectDTO.builder().name("Matematica").score(8.0).build());
        subjectDTOList.add(SubjectDTO.builder().name("Geografia").score(7.0).build());
        StudentDTO student = StudentDTO.builder().studentName("Juan").subjects(subjectDTOList).build();
        ArgumentCaptor<StudentDTO> valueCapture = ArgumentCaptor.forClass(StudentDTO.class);
        Mockito.doNothing().when(this.studentDAO).save(valueCapture.capture());
        //execute
        this.service.update(student);
        //check
        Assertions.assertEquals("Juan", valueCapture.getValue().getStudentName());
    }

    @Test
    public void deveRealizarDeletePorId(){
        this.service.delete(Mockito.any());
        Mockito.verify(this.studentDAO, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    public void deveRetornarTodaALista(){
        //setup
        Set<StudentDTO> studentDTOS = new HashSet<>();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(SubjectDTO.builder().name("Matematica").score(8.0).build());
        subjectDTOList.add(SubjectDTO.builder().name("Geografia").score(7.0).build());
        StudentDTO student1 = StudentDTO.builder().studentName("Juan").subjects(subjectDTOList).build();
        StudentDTO student2 = StudentDTO.builder().studentName("Maria").subjects(subjectDTOList).build();
        studentDTOS.add(student1);
        studentDTOS.add(student2);
        Mockito.when(this.studentRepository.findAll()).thenReturn(studentDTOS);
        //execute
        Set<StudentDTO> result = this.service.getAll();
        //check
        Assertions.assertEquals(2,result.size());
    }

}
