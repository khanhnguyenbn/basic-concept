package com.example.baseconcept.service;

import com.example.baseconcept.exception.StudentNotFoundException;
import com.example.baseconcept.model.Student;
import com.example.baseconcept.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public List<Student> getStudents() throws Exception {

//        List<Student> students = new ArrayList<>();
//
//        Student student = new Student();
//        student.setId(1);
//        student.setName("Nguyen Ba Khanh");
//        student.setYearOld(23);
//
//        Student student2 = new Student();
//        student2.setId(2);
//        student2.setName("Do Duc An");
//        student2.setYearOld(18);
//
//        students.add(student);
//        students.add(student2);

//        return students;
        throw new Exception("student not found");
//        throw new StudentNotFoundException("Student not found");
    }

    public Student saveStudent(Student student) {

        return studentRepository.save(student);

    }


}
