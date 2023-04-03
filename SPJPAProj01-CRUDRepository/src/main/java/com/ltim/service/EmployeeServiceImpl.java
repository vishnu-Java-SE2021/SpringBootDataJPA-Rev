package com.ltim.service;

import java.util.ArrayList;
import java.util.Collection;
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

	@Override
	public String registerAllEmps(Iterable<Employee> emps) {

		Iterable<Employee> savedEmps = empRepo.saveAll(emps);
		
		List<Integer> ids = new ArrayList<>();
		
		for(Employee e : savedEmps) {
			ids.add(e.getEid());
		}
		
		return ids.toString()+" id's related emps are registered";
	}

	@Override
	public String updateEmpDetails(Integer id, String dept, Double sal) {
		Employee e = empRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("No record found with id :: "+id));
		e.setDept(dept);
		e.setSal(sal);
		empRepo.save(e);
		return "Emp updated";
		
//		Optional<Employee> opt  = empRepo.findById(id);
//		
//		if(opt.isPresent()) {
//			Employee e = opt.get();
//			e.setDept(dept);
//			e.setSal(sal);
//			empRepo.save(e);
//			return "Emp updated";
//		}else {
//			throw new IllegalArgumentException("No emp found with id :: "+id);
//		}
	}
	
		@Override
		public String updateEmp(Employee emp) {
			
			Optional<Employee> opt  = empRepo.findById(emp.getEid());
			
			if(opt.isPresent()) {
				Employee e = opt.get();
				e.setEname(emp.getEname());
				e.setDept(emp.getDept());
				e.setSal(emp.getSal());
				
				empRepo.save(e);
				return "Emp updated";
			}else {
				throw new IllegalArgumentException("No emp found with id :: "+emp.getEid());
			}
	}
		
	@Override
	public String removeEmp(Employee emp) {
		empRepo.findById(emp.getEid()).orElseThrow(()-> new IllegalArgumentException("No emp found with id :: "+emp.getEid()));
		
		empRepo.delete(emp);
		return "emp with id :: "+emp.getEid()+" is deleted";
	}
	
	@Override
	public String removeEmpById(Integer id) {
		Optional<Employee> emp = empRepo.findById(id);
	
		if(emp.isPresent()) {
			empRepo.deleteById(id);
			return "emp with id :: "+id+" is deleted";
		}else {
			throw new IllegalArgumentException("No emp found with id :: "+id);
		}
	}
	
	@Override
	public String removeEmpsByIds(Iterable<Integer> ids) {
		
		List<Employee> empList = (List<Employee>) empRepo.findAllById(ids);
		
		long count = empList.size();
		
		if(count>0) {
			empRepo.deleteAllById(ids);
			return ids.toString()+" related records are deleted";
		}else {
			throw new IllegalArgumentException("No records found with id's :: "+ids.toString());
		}
		
	}

}
