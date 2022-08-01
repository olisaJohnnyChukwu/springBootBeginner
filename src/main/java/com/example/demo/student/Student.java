package com.example.demo.student;
import java.time.LocalDate;

import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter

public class Student {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    

    


    
    public Student(String name, String email,LocalDate dob, Integer age) {
        this.name = name;
        this.email=email;
        this.dob = dob;
        this.age = age;
    }


    



    public Student(Long id, String name,String email,LocalDate dob, Integer age) {
        this.id = id;
        this.name = name;
        this.email=email;
        this.dob = dob;
        this.age = age;
    }



    



    

    

    


    


    
}
