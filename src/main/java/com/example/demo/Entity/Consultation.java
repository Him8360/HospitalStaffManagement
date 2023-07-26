package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Consultation {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Consult_seq")
	@SequenceGenerator(sequenceName="Consult_seq",name="Consult_seq", allocationSize=1)
	private Long id;
	private String dos;
	private String dont;
	private String medicines;
	
	
}
