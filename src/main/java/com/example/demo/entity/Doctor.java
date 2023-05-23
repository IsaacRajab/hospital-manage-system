package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "Doctor"
)

public class Doctor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "name")
    private  String name;

    @Column(name = "specialization")
    private  String specialization;

    @Column(name= "rank")
    private String rank;

    @Column(name = "salary")
    private int Salary;





}
