package com.example.demo.student;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.demo.address.Address;

import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Student {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;
    


    
    public Student(String name, String email,LocalDate dob) {
        this.name = name;
        this.email=email;
        this.dob = dob;
        this.age = Period.between(this.dob, LocalDate.now()).getYears();
    }


    



    public Student(Long id, String name,String email,LocalDate dob, Integer age) {
        this.id = id;
        this.name = name;
        this.email=email;
        this.dob = dob;
        this.age = Period.between(this.dob, LocalDate.now()).getYears();
    }


    

    



    

    

    


    


    
}
