package com.example.demo.service;

import com.example.demo.entity.PatientData;
import com.example.demo.entity.dto.PatientDataDTO;
import com.example.demo.mapper.DTOEntityMapper;
import com.example.demo.repository.PatientDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.mapper.DTOEntityMapper.mapDTOToPatientData;
import static com.example.demo.mapper.DTOEntityMapper.mapPatientDataToDTO;

@Service
public class PatientDataService {
    @Autowired
    private  PatientDataRepository patientDataRepository;



    public PatientDataDTO getPatientDataById(Long id) {
        Optional<PatientData> patientData = patientDataRepository.findById(id);
        return patientData.map(DTOEntityMapper::mapPatientDataToDTO).orElse(null);
    }

    public PatientDataDTO createPatientData(PatientDataDTO patientDataDTO) {
        PatientData patientData = mapDTOToPatientData(patientDataDTO);
        PatientData createdPatientData = patientDataRepository.save(patientData);
        return mapPatientDataToDTO(createdPatientData);
    }

    public PatientDataDTO updatePatientData(Long id, PatientDataDTO patientDataDTO) {
        Optional<PatientData> patientData = patientDataRepository.findById(id);
        if (patientData.isPresent()) {
            PatientData existingPatientData = patientData.get();
            existingPatientData.setNicNumber(patientDataDTO.getNicNumber());
            existingPatientData.setSickness(patientDataDTO.getSickness());
            existingPatientData.setPhone(patientDataDTO.getPhone());
            PatientData updatedPatientData = patientDataRepository.save(existingPatientData);
            return mapPatientDataToDTO(updatedPatientData);
        } else {
            return null;
        }
    }

    public boolean deletePatientData(Long id) {
        Optional<PatientData> patientData = patientDataRepository.findById(id);
        if (patientData.isPresent()) {
            patientDataRepository.delete(patientData.get());
            return true;
        } else {
            return false;
        }
    }


}

