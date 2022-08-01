package com.example.demo.student;


import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public void addNewStudent( Student student) {

        Optional<Student> studentOptonal=studentRepository.findStudentByEmail(student.getEmail());
        System.out.println(student.getEmail());
        if(studentOptonal.isPresent()){
            
            throw new IllegalStateException("email taken");
        }else{
            studentRepository.save(student);
        }
        
    }

	public void deleteStudent(Long id) {

        boolean exists =studentRepository.existsById(id);
        

        if(!exists){
            throw new IllegalStateException("User not found");
        }

        studentRepository.deleteById(id);
         
	}


    @Transactional
    public void updateStudent(Long id, String name, String email) {

        Student student=studentRepository.findById(id).orElseThrow(()->{
            throw new IllegalStateException("User not found");
        });

        if(name!=null && name.length()>0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email !=null && email.length()>0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> optionalStudent =studentRepository.findStudentByEmail(email);
            if(optionalStudent.isPresent()){
                throw new IllegalStateException("User not found");
            }
            student.setEmail(email);
        } 



    }




    
    
}
