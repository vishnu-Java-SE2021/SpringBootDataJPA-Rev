package com.ltim.service;

import java.util.List;

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

	@Override
	public int fetchEmpCount() {
		System.out.println(empRepo.getClass());
		return (int)empRepo.count();
	}

	@Override
	public Boolean hasEmpId(int id) {
		return empRepo.existsById(id);
	}

	@Override
	public Iterable<Employee> fetchAllEmps() {
		return empRepo.findAll();
	}

	@Override
	public Iterable<Employee> fetchEmpsByIds(List<Integer> ids) {
		return empRepo.findAllById(ids);
	}

}
