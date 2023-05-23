package com.example.demo.controller;

import com.example.demo.entity.PatientData;
import com.example.demo.entity.dto.PatientDataDTO;
import com.example.demo.service.PatientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient-data")
public class PatientDataController {
    private final PatientDataService patientDataService;

    @Autowired
    public PatientDataController(PatientDataService patientDataService) {
        this.patientDataService = patientDataService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDataDTO> getPatientData(@PathVariable("id") Long id) {
        PatientDataDTO patientDataDTO = patientDataService.getPatientDataById(id);
        if (patientDataDTO != null) {
            return ResponseEntity.ok(patientDataDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PatientDataDTO> createPatientData(@RequestBody PatientDataDTO patientDataDTO) {
        PatientDataDTO createdPatientDataDTO = patientDataService.createPatientData(patientDataDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatientDataDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDataDTO> updatePatientData(@PathVariable("id") Long id, @RequestBody PatientDataDTO patientDataDTO) {
        PatientDataDTO updatedPatientDataDTO = patientDataService.updatePatientData(id, patientDataDTO);
        if (updatedPatientDataDTO != null) {
            return ResponseEntity.ok(updatedPatientDataDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientData(@PathVariable("id") Long id) {
        boolean deleted = patientDataService.deletePatientData(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
