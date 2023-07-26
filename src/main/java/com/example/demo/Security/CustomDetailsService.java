package com.example.demo.Security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Entity.Staff;
import com.example.demo.Repository.StaffRepository;

public class CustomDetailsService implements UserDetailsService {

	@Autowired 
	private StaffRepository staffDao;
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException
	{
		Staff staff=staffDao.findByEmail(usernameOrEmail).orElseThrow(()-> new UsernameNotFoundException("User not found with username or email: "+usernameOrEmail));
	   return new org.springframework.security.core.userdetails.User(staff.getEmail(),staff.getPassword(),new  ArrayList<>());
	}
}
