package com.ltim.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Employee fetchEmpById(int id) {
//		Optional<Employee> opt = empRepo.findById(id);
//		
//		if(opt.isPresent()) {
//			Employee e = opt.get();
//			return e;
//		}else {
//			throw new IllegalArgumentException("No record found with id :: "+id);
//		}
		
//		return empRepo.findById(id).orElse(new Employee());
		return empRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("No record found"));
	}

	@Override
	public Optional<Employee> searchEmpById(int id) {
		Optional<Employee> opt = empRepo.findById(id);
		 return opt.isPresent()? opt :  Optional.empty();
	}

}
