package com.example.demo.entity.dto;

import lombok.Data;

@Data
public class MedicalReportDTO {
    private long id ;
    private PatientDataDTO patientDataDTO;

    public PatientDataDTO getPatientDataDTO() {
        return patientDataDTO;
    }

    public void setPatientDataDTO(PatientDataDTO patientDataDTO) {
        this.patientDataDTO = patientDataDTO;
    }
}
