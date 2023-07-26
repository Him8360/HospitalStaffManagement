package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Patient;
import com.example.demo.Entity.Status;

public interface patientRepository extends JpaRepository<Patient,Long> {
	List<Patient> findByStatus(Status s);
}
