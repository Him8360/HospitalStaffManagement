package com.example.demo.Entity;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="patient_seq")
	@SequenceGenerator(sequenceName="patient_seq",name="patient_seq",allocationSize=1)
	private long patientId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNo;
	private String bloodGroup;
	private String gender;
	private int due;
	private Date admitDate;
	
	@Enumerated(EnumType.ORDINAL)
	private Status  status;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Problem> problems;
	
	
	
	
	
}
