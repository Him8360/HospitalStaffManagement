package com.example.demo.Service;

import java.sql.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Staff;
import com.example.demo.Repository.StaffRepository;
import com.example.demo.dto.staffDto;
@Component("staffServiceImpl")
public class staffServiceImpl implements staffService {
	@Bean 
	public static ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	private final ModelMapper modelMapper;
	public staffServiceImpl(ModelMapper modelMapper)
	{
		this.modelMapper=modelMapper;
	}
	@Autowired 
	private StaffRepository staffDao;
	@Override
	public staffDto save(Staff s)
	{
s=staffDao.save(s);
		staffDto staffDto=modelMapper.map(s,staffDto.class);
		return staffDto;
	}
	@Override
	public boolean existByEmail( String Email)
	{
		return staffDao.existsByEmail(Email);
	}
	
}
