package com.example.baseconcept.exception;

import lombok.Data;

@Data
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}
