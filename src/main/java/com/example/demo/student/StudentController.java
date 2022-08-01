package com.example.demo.student;

import java.time.LocalDate;
import java.util.*;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {


    @GetMapping
	public  List<Student> getStudents(){
		return List.of(new Student(1L,"mariam","mariam@gmail.com",LocalDate.now(),22));

	}

    

    
}
