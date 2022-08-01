package com.example.demo.student;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;




    @GetMapping
	public  List<Student> getStudents(){
		
        return studentService.getStudents();

	}



    
}
