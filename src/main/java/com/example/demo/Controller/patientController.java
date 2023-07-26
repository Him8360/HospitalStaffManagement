package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.patientService;

@RestController
@RequestMapping("/patient")
public class patientController {
	@Autowired
	private patientService patientService;
	
	@GetMapping("/listAll")
	public ResponseEntity<?> listAllPatients()
	{
		
		return ResponseEntity.ok(patientService.findAll());
	}
	@GetMapping("/listAllAdmit")
	public ResponseEntity<?> listAllAdmitPatients()
	{
		return ResponseEntity.ok(patientService.findAllAdmitted());
		
	}
	@GetMapping("/patientId")
	public ResponseEntity<?> patientDetails(@RequestParam long patientId)
	{
	  return ResponseEntity.ok(patientService.findById(patientId));
	}
	@GetMapping("/problem")
	public ResponseEntity<?> problemDetails(@RequestParam long patientId)
	{
	  return ResponseEntity.ok(patientService.problems(patientId));
	}
	@PatchMapping("/discharge")
	public ResponseEntity<?> discharge(@RequestParam long patientId)
	{
		if(patientService.discharge(patientId))
		{
			return new ResponseEntity<>("Patient Succesfully Discharged!", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("No Details Found!", HttpStatus.BAD_REQUEST);
	}
	@PatchMapping("/expenses")
	public ResponseEntity<?> expense(@RequestParam long patientId,@RequestParam int expenses)
	{
		if(patientService.addExpenses(patientId, expenses))
		{
			return new ResponseEntity<>("Added Succesfully!", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("No Details Found!", HttpStatus.BAD_REQUEST);
	}
	
	
	

}
