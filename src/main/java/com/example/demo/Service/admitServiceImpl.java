package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Admit;
import com.example.demo.Entity.Status;
import com.example.demo.Repository.admitRepository;

@Component("admitServiceImpl")
public class admitServiceImpl  implements admitService{

	@Autowired
	private admitRepository admitRepository;
	
	@Override
	public Admit save(Admit admit) {
		admit.getPatient().setStatus(Status.ADMITTED);
		return admitRepository.save(admit);
	}

	

}
