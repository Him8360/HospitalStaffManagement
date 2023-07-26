package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Patient;
import com.example.demo.Entity.Problem;
import com.example.demo.dto.patientDto;

public interface patientService {
	public List<patientDto> findAll();
	public List<patientDto> findAllAdmitted();
	public Patient findById(Long patientId);
    public boolean discharge(Long patientId);
    public boolean addExpenses(Long patientId,int expenses);
    public List<Problem> problems(Long patientId);
}
