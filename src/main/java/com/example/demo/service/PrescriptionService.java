package com.example.demo.service;

import com.example.demo.entity.Prescription;

import com.example.demo.entity.dto.PrescriptionDTO;
import com.example.demo.mapper.DTOEntityMapper;
import com.example.demo.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrescriptionService {
    @Autowired
    private  PrescriptionRepository prescriptionRepository;



    public PrescriptionDTO getPrescriptionById(Long id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        return prescription.map(DTOEntityMapper::mapPrescriptionToDTO).orElse(null);
    }

    public PrescriptionDTO createPrescription(PrescriptionDTO prescriptionDTO) {
        Prescription prescription = DTOEntityMapper.mapDTOToPrescription(prescriptionDTO);
        Prescription createdPrescription = prescriptionRepository.save(prescription);
        return DTOEntityMapper.mapPrescriptionToDTO(createdPrescription);
    }

    public PrescriptionDTO updatePrescription(Long id, PrescriptionDTO prescriptionDTO) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        if (prescription.isPresent()) {
            Prescription existingPrescription = prescription.get();
            existingPrescription.setSerialNumber(prescriptionDTO.getSerialNumber());
            existingPrescription.setPatientData(DTOEntityMapper.mapDTOToPatientData(prescriptionDTO.getPatientData()));
            // Map other properties as needed
            Prescription updatedPrescription = prescriptionRepository.save(existingPrescription);
            return DTOEntityMapper.mapPrescriptionToDTO(updatedPrescription);
        } else {
            return null;
        }
    }

    public boolean deletePrescription(Long id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        if (prescription.isPresent()) {
            prescriptionRepository.delete(prescription.get());
            return true;
        } else {
            return false;
        }
    }
}
