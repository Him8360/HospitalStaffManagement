package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Staff;

public interface StaffRepository extends JpaRepository<Staff,Long> {
	Optional<Staff> findByEmail(String email);
    Boolean existsByEmail(String email);
}
