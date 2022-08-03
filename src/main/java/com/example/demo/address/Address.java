package com.example.demo.address;

import javax.persistence.*;



import com.example.demo.student.Student;

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
    private Student student;

    public Address(Integer number, String street) {
        this.number = number;
        this.street = street;
    }


    

    
}
