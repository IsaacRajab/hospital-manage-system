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
@Table
public class PatientData {
    @Id
    @GeneratedValue
    private  long id;

    @Column(name = "NIC_number",nullable = false,updatable = false)
    private int NicNumber;

    @Column(name = "Sickness")
    private String sickness;

    @Column(name = "Phone_Number",nullable = false)
    private  int phone;
}
