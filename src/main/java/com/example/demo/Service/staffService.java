package com.example.demo.Service;

import com.example.demo.Entity.Staff;
import com.example.demo.dto.staffDto;

public interface staffService {

	staffDto save(Staff s);
	boolean existByEmail(String Email);
    //Staff loadStaffByUsername(String usernameOrEmail) throws UsernameNotFoundException;
}
