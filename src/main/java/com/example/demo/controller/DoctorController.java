package com.example.demo.controller;


import com.example.demo.entity.dto.DoctorDTO;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController                                 // to use rest api  get post delete
@RequestMapping("/doctors")                 // the request to check doctor localhost:9090/doctors
public class DoctorController {
   @Autowired                                  // that's used to enjict the constructor
   private  DoctorService doctorService;


        @GetMapping("/{id}")
        public ResponseEntity<DoctorDTO> getDoctor(@PathVariable("id") Long id) {
            DoctorDTO doctorDTO = doctorService.getDoctorById(id);
            if (doctorDTO != null) {
                return ResponseEntity.ok(doctorDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
            DoctorDTO createdDoctorDTO = doctorService.createDoctor(doctorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDoctorDTO);
        }

        @PutMapping("/{id}")
        public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorDTO doctorDTO) {
            DoctorDTO updatedDoctorDTO = doctorService.updateDoctor(id, doctorDTO);
            if (updatedDoctorDTO != null) {
                return ResponseEntity.ok(updatedDoctorDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteDoctor(@PathVariable("id") Long id) {
            boolean deleted = doctorService.deleteDoctor(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }


