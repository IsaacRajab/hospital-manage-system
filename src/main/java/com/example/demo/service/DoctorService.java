package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.dto.DoctorDTO;
import com.example.demo.mapper.DTOEntityMapper;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.mapper.DTOEntityMapper.mapDoctorDTOToDoctor;
import static com.example.demo.mapper.DTOEntityMapper.mapDoctorToDoctorDTO;

@Service
public class DoctorService {    // THATS CONTAINS THE BUSINESS LOGIC

    @Autowired
    private  DoctorRepository doctorRepository;



    public DoctorDTO getDoctorById(Long id) {                           // GET THE DOCTOR BY THE ID FROM THE DATABASE AND RETURN IT AS DTO  to not showing the id to user
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.map(DTOEntityMapper::mapDoctorToDoctorDTO).orElse(null);
    }

    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = mapDoctorDTOToDoctor(doctorDTO);             // add new doctor to the database
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


}
