package com.example.demo.dto;

import java.sql.Date;
import java.util.List;

import com.example.demo.Entity.Problem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class patientDto {
	private long patientId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNo;
	private String bloodGroup;
	private String gender;
	private String due;
	private Date admitDate;
}
