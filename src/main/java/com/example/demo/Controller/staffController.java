package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Staff;
import com.example.demo.Service.staffService;
import com.example.demo.dto.Login;
import com.example.demo.dto.staffDto;

@RestController
@RequestMapping("/staff")
public class staffController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	@Qualifier("staffServiceImpl")
	private staffService staffService;
	@PostMapping("/signin")
	public ResponseEntity<String> authenticateUser (@RequestBody Login login)throws Exception
	{
		try {
		Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		}
		catch (BadCredentialsException e)
		{
			throw new Exception("Invalid credentials");
		}
		return new ResponseEntity<>("User Signed in Successfully!",HttpStatus.OK);
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody Staff s)
	{
		if(staffService.existByEmail(s.getEmail()))
		{
			return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
			
		}
		s.setPassword(passwordEncoder.encode(s.getPassword()));
		return ResponseEntity.ok(staffService.save(s));
	}
	
}
