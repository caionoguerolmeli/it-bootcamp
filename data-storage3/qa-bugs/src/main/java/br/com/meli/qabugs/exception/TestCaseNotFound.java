package br.com.meli.qabugs.exception;

public class TestCaseNotFound extends RuntimeException{
    public TestCaseNotFound(Long id) {
        super("TestCase id "+id+" not found");
    }
}
