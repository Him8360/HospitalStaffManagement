package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Admit;
import com.example.demo.Service.admitService;

@RestController
@RequestMapping("/admit")
public class admitController {

	@Autowired
	@Qualifier("admitServiceImpl")
	private admitService admitService;
	@PostMapping("/insert")
	public ResponseEntity<?> admission(@RequestBody Admit admit)
	{
		return ResponseEntity.ok(admitService.save(admit));	
	}
}
