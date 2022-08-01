package com.example.demo.student;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public void addNewStudent(@RequestBody Student student) {

        Optional<Student> studentOptonal=studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptonal.isPresent()){
            throw new IllegalStateException("email taken");
        }

        
        studentRepository.save(student);
    }



    
    
}
