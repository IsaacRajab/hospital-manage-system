package com.example.demo.entity.dto;




import lombok.Data;

@Data
public class PrescriptionDTO {

    private String serialNumber;

    private PatientDataDTO patientData;
}
