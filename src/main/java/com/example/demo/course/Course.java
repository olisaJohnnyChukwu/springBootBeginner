package com.example.demo.course;

import javax.persistence.*;

import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "course")
    private Student student;


    public Course(String name){
        this.name=name;
    }


    
}
