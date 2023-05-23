package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor                         // build our database  table
@NoArgsConstructor
@Entity
@Table(
        name = "Doctor"   /// naming the table
)

public class Doctor {
    @Id                         //  uto increment id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "name")              // add column to Database
    private  String name;

    @Column(name = "specialization")
    private  String specialization;

    @Column(name= "rank")
    private String rank;

    @Column(name = "salary")
    private int Salary;





}
