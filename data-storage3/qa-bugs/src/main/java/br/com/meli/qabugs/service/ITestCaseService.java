package br.com.meli.qabugs.service;

import br.com.meli.qabugs.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCase save(TestCase testCase);
    TestCase findById(Long id);
    List<TestCase> findAll();
    List<TestCase> findByLastUpdate(String date);

    void delete(Long id);

}
