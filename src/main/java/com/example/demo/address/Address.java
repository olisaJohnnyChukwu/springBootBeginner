package com.example.demo.address;

import javax.persistence.*;



import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;
import lombok.ToString.Exclude;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private Integer number;
    private String street;

    @Exclude
    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Student student;

    public Address(Integer number, String street) {
        this.number = number;
        this.street = street;
    }


    

    
}
