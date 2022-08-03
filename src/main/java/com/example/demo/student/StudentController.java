package com.example.demo.student;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.address.Address;


@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;




    @GetMapping
	public  List<Student> getStudents(){
		
        return studentService.getStudents();

	}


    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }



    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }


    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
    @RequestParam(required =false) String name,
    @RequestParam(required =false) String email) {

        studentService.updateStudent(id,name,email);
        
    }



    @GetMapping(path="address/{studentId}")
	public  Address findAddress(@PathVariable("studentId") Long id){
		
        return studentService.getAddress(id);

	}
    
}
