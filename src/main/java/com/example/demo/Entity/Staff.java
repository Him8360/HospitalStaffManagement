package com.example.demo.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="astaff")
public class Staff {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="User_seq")
	@SequenceGenerator(sequenceName="User_seq",name="User_seq",allocationSize=1)
	private long id;
	private String username;
    private String firstName;
    private String middileName;
    private String lastName;
    private String gender;
    @Column(unique=true)
    private String email;
    private String password;

	private Date dateOfJoining;
    private Date dateOfBirth;
    private String role;
    @Enumerated(EnumType.ORDINAL)
    private Department department;
    private String Specialization;
   
}
