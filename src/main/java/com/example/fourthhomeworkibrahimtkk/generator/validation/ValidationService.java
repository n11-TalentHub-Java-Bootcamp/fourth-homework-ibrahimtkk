package com.example.fourthhomeworkibrahimtkk.generator.validation;

public interface ValidationService<T> {
    ValidationResult validate(T request);
}
