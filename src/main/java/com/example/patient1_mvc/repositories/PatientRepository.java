package com.example.patient1_mvc.repositories;

import com.example.patient1_mvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public Page<Patient> findByNameContains(String Keyword, Pageable pageable);
}
