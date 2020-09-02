package com.example.baseconcept.controller;

import com.example.baseconcept.model.Student;
import com.example.baseconcept.payload.ApiDefaultResponse;
import com.example.baseconcept.payload.ApiSuccessResponse;
import com.example.baseconcept.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @ApiOperation(value = "View list student")
    @GetMapping()
    public ApiDefaultResponse<Object> getStudents(@ApiParam(value = "id of student", defaultValue = "1") @RequestParam("id") String id) throws Exception {

//        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);

        log.info("test log");

        return new ApiSuccessResponse<>(studentService.getStudents());
    }

    @ApiOperation(value = "Save student")
    @PostMapping
    public ApiDefaultResponse<Object> saveStudent() throws Exception {


        return new ApiSuccessResponse<>(studentService.saveStudent(Student.builder()
                .name("Khanh")
                .yearOld(18)
                .build()));
    }


}
