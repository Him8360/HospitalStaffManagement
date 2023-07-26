package com.example.demo.dto;

import java.sql.Date;

import com.example.demo.Entity.Department;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class staffDto {

	private long id;
	private String username;
    private String firstName;
    private String middileName;
    private String lastName;
    private String gender;
    private String email;
    private Date dateOfJoining;
    private Date dateOfBirth;
    private String Specialization;
}
