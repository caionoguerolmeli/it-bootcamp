package br.com.meli.qabugs.service;

import br.com.meli.qabugs.exception.TestCaseNotFound;
import br.com.meli.qabugs.model.TestCase;
import br.com.meli.qabugs.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    TestCaseRepository repository;

    @Override
    public TestCase save(TestCase testCase) {
        return this.repository.save(testCase);
    }

    @Override
    public TestCase findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new TestCaseNotFound(id)) ;
    }

    @Override
    public List<TestCase> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<TestCase> findByLastUpdate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.repository.findAllByLastUpdate(LocalDate.parse(date,formatter));
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        this.repository.deleteById(id);
    }
}
