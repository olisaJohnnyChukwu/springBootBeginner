package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import com.example.demo.address.Address;
import com.example.demo.address.AddressRepository;
import com.example.demo.course.Course;
import com.example.demo.course.CourseRepository;

@Configuration
public class StudentConfig {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CourseRepository courseRepository;

    @Bean
    CommandLineRunner commandLineRunner(){

        return args ->{

            Address a1=new Address(27426, "Fairfax");
            Address a2=new Address(27436, "Suffolk");
            Address a3=new Address(27436, "curry");
            Student s1=new Student("olisa","olisa@gmail.com",LocalDate.of(1999, Month.FEBRUARY, 7));
            
            s1.setAddress(a1);
            a1.setStudent(s1);
            

            Student s2=new Student("obinna","obinna@gmail.com",LocalDate.of(1994, Month.SEPTEMBER, 23));
            s2.setAddress(a2);
            a2.setStudent(s2);

            Student s3=new Student("chinaza","chinaza@gmail.com",LocalDate.of(1996, Month.MAY, 5));
            s3.setAddress(a3);
            a3.setStudent(s3);


            Course c1=new Course("Math");
            Course c2=new Course("English");
            Course c3=new Course("Biology");

            s1.setCourse(c1);
            // c1.setStudent(s1);


            s2.setCourse(c2);
            // c2.setStudent(s1);


            s3.setCourse(c3);
            // c3.setStudent(s3);

            studentRepository.saveAll(List.of(s1,s2,s3));
            addressRepository.saveAll(List.of(a1,a2,a3));
            courseRepository.saveAll(List.of(c1,c2,c2));


            
        };

        
    }
    
}
