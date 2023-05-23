package com.example.demo.repository;

import com.example.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {    // GIVE ME ALL METHODS IN THE DATABASE LIKE GETBYID ALSO FIND ALL
}
