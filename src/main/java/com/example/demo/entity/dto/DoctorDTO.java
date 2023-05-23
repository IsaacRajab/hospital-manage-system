package com.example.demo.entity.dto;


import lombok.Data;

@Data
public class DoctorDTO {                    // the DTO USED FOR  SHOW THE USER WHAT I WANT NOT ALL THINGS IN DATABASE

    private  String name;
    private  String specialization;

    private String rank;

    private int Salary;
}
