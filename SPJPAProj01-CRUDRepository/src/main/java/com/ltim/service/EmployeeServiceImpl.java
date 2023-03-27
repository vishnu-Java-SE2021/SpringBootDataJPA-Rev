package com.ltim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltim.entity.Employee;
import com.ltim.repo.IEmployeeRepo;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo empRepo;
	
	@Override
	public String registerEmp(Employee emp) {
		Employee e = empRepo.save(emp);
		return "Employee is registered with id :: "+e.getEid();
	}

}
