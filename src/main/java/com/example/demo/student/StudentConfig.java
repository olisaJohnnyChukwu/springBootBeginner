package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

@Configuration
public class StudentConfig {

    @Autowired
    StudentRepository studentRepository;

    @Bean
    CommandLineRunner commandLineRunner(){

        return args ->{
            Student s1=new Student("olisa","olisa@gmail.com",LocalDate.of(1999, Month.FEBRUARY, 7));
            Student s2=new Student("obinna","obinna@gmail.com",LocalDate.of(1994, Month.SEPTEMBER, 23));
            Student s3=new Student("chinaza","chinaza@gmail.com",LocalDate.of(1996, Month.MAY, 5));

            studentRepository.saveAll(List.of(s1,s2,s3));
        };

        
    }
    
}
