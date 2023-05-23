package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.dto.DoctorDTO;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private  DoctorRepository doctorRepository;



    public DoctorDTO getDoctorById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            return mapDoctorToDoctorDTO(doctor.get());
        } else {
            return null;
        }
    }

    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = mapDoctorDTOToDoctor(doctorDTO);
        Doctor createdDoctor = doctorRepository.save(doctor);
        return mapDoctorToDoctorDTO(createdDoctor);
    }

    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            Doctor existingDoctor = doctor.get();
            existingDoctor.setName(doctorDTO.getName());
            existingDoctor.setSpecialization(doctorDTO.getSpecialization());
            existingDoctor.setRank(doctorDTO.getRank());
            existingDoctor.setSalary(doctorDTO.getSalary());
            Doctor updatedDoctor = doctorRepository.save(existingDoctor);
            return mapDoctorToDoctorDTO(updatedDoctor);
        } else {
            return null;
        }
    }

    public boolean deleteDoctor(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            doctorRepository.delete(doctor.get());
            return true;
        } else {
            return false;
        }
    }

    private DoctorDTO mapDoctorToDoctorDTO(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setName(doctor.getName());
        doctorDTO.setSpecialization(doctor.getSpecialization());
        doctorDTO.setRank(doctor.getRank());
        doctorDTO.setSalary(doctor.getSalary());
        return doctorDTO;
    }

    private Doctor mapDoctorDTOToDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setRank(doctorDTO.getRank());
        doctor.setSalary(doctorDTO.getSalary());
        return doctor;
    }
}
