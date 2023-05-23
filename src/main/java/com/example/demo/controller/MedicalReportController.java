package com.example.demo.controller;

import com.example.demo.entity.MedicalReport;
import com.example.demo.entity.dto.MedicalReportDTO;
import com.example.demo.service.MedicalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-reports")
public class MedicalReportController {

    @Autowired
    private  MedicalReportService medicalReportService;




    @GetMapping("/{id}")
    public ResponseEntity<MedicalReportDTO> getMedicalReport(@PathVariable("id") Long id) {
        MedicalReportDTO medicalReportDTO = medicalReportService.getMedicalReportById(id);
        if (medicalReportDTO != null) {
            return ResponseEntity.ok(medicalReportDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MedicalReportDTO> createMedicalReport(@RequestBody MedicalReportDTO medicalReportDTO) {
        MedicalReportDTO createdMedicalReportDTO = medicalReportService.createMedicalReport(medicalReportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedicalReportDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalReportDTO> updateMedicalReport(@PathVariable("id") Long id, @RequestBody MedicalReportDTO medicalReportDTO) {
        MedicalReportDTO updatedMedicalReportDTO = medicalReportService.updateMedicalReport(id, medicalReportDTO);
        if (updatedMedicalReportDTO != null) {
            return ResponseEntity.ok(updatedMedicalReportDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalReport(@PathVariable("id") Long id) {
        boolean deleted = medicalReportService.deleteMedicalReport(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
