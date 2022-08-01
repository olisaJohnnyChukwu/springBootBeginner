package com.example.demo.student;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {

        return List.of(new Student(1L,"mariam","mariam@gmail.com",LocalDate.now(),22));
    }
    
}
