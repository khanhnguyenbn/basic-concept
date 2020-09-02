package com.example.baseconcept.repository;

import com.example.baseconcept.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
