package com.example.demo.Entity;

import java.util.List;

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
public class Problem {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="prob_seq")
@SequenceGenerator(sequenceName="prob_seq",name="prob_seq",allocationSize=1)
	private long id;
private String problemDetails;
@Enumerated(EnumType.ORDINAL)
private Department problemDepartment;
@OneToMany(cascade=CascadeType.ALL)
private List<Consultation> consultation;

}
