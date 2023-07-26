package com.example.demo.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Admit {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Admit_seq")
@SequenceGenerator(sequenceName="dep_seq",name="dep_seq",allocationSize=1)
private long admitId;
@OneToOne(cascade=CascadeType.ALL)
private Patient patient;

}
