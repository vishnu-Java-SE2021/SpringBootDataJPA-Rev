package com.ltim.service;

import java.util.List;
import java.util.Optional;

import com.ltim.entity.Employee;

public interface IEmployeeService {

	public String registerEmp(Employee emp);
	public int fetchEmpCount();
	public Boolean hasEmpId(int id);
	public Iterable<Employee> fetchAllEmps();
	public Iterable<Employee> fetchEmpsByIds(List<Integer> ids);
	public Employee fetchEmpById(int id);
	public Optional<Employee> searchEmpById(int id);
}
