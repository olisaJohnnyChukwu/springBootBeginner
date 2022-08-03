package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import com.example.demo.address.Address;

@Configuration
public class StudentConfig {

    @Autowired
    StudentRepository studentRepository;

    @Bean
    CommandLineRunner commandLineRunner(){

        return args ->{

            Address a1=new Address(27426, "Fairfax");
            Address a2=new Address(27436, "Suffolk");
            Student s1=new Student("olisa","olisa@gmail.com",LocalDate.of(1999, Month.FEBRUARY, 7));
            s1.setAddress(a1);

            Student s2=new Student("obinna","obinna@gmail.com",LocalDate.of(1994, Month.SEPTEMBER, 23));
            s2.setAddress(a2);
            Student s3=new Student("chinaza","chinaza@gmail.com",LocalDate.of(1996, Month.MAY, 5));

            studentRepository.saveAll(List.of(s1,s2,s3));
        };

        
    }
    
}
