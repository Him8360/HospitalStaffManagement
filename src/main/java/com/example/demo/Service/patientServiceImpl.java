package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Patient;
import com.example.demo.Entity.Problem;
import com.example.demo.Entity.Status;
import com.example.demo.Repository.patientRepository;
import com.example.demo.dto.patientDto;

@Component("patientServiceImpl")
public class patientServiceImpl implements patientService {

	private final ModelMapper modelMapper;
	public  patientServiceImpl(ModelMapper modelMapper)
	{
		this.modelMapper=modelMapper;
	}
	@Autowired
	private patientRepository patientRepository; 
	
	@Override
	public List<patientDto> findAll() {
		// TODO Auto-generated method stub
	List<Patient> patient=patientRepository.findAll();
	patientDto[] patientDto=modelMapper.map(patient, patientDto[].class);
	return Arrays.asList(patientDto);
	}

	@Override
	public Patient findById(Long PatientId) {
		// TODO Auto-generated method stub
		Optional<Patient> patient=patientRepository.findById(PatientId);
		if(patient.isPresent())
		{
			return patient.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean discharge(Long patientId) {
		// TODO Auto-generated method stub
	  Optional<Patient> patient=patientRepository.findById(patientId);
	  if(patient.isPresent())
	  {
		  patient.get().setStatus(Status.DISCHARGED);
		  patientRepository.save(patient.get());
		  return true;
		  
	  }
	  return false;
	  
	}

	@Override
	public boolean addExpenses(Long patientId, int expenses) {
		// TODO Auto-generated method stub
		  Optional<Patient> patient=patientRepository.findById(patientId);
		  if(patient.isPresent())
		  {
			  patient.get().setDue(((patient.get().getDue()+expenses)));
			  patientRepository.save(patient.get());
			  return true;
			  
		  }
		  return false;
	}

	@Override
	public List<Problem> problems(Long patientId) {
		// TODO Auto-generated method stub
		Optional<Patient> patient=patientRepository.findById(patientId);
		  if(patient.isPresent())
		  {
			 List<Problem> problem= patient.get().getProblems();
			  return problem;
		  }
		  return new ArrayList<Problem>();
		
	}

	@Override
	public List<patientDto> findAllAdmitted() {
		// TODO Auto-generated method stub
		List<Patient> patient=patientRepository.findByStatus(Status.ADMITTED);
		patientDto[] patientDto=modelMapper.map(patient, patientDto[].class);
		return Arrays.asList(patientDto);
		
	}
	
	

	
}
