package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Admit;

public interface admitRepository extends JpaRepository<Admit, Long> {

}
