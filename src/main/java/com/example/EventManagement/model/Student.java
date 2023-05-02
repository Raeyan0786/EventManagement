package com.example.EventManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column
    private String  first_name;
    @Column
    private String last_name;
    @Column
    private int age;
    @Enumerated(EnumType.STRING)//only for watching strings in DB.
    private Department department;//CAN ONLY BE ME , ECE , civil , CSE
}
