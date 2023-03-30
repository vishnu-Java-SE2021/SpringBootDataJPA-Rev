package com.ltim.service;

import java.util.List;

import com.ltim.entity.Employee;

public interface IEmployeeService {

	public String registerEmp(Employee emp);
	public int fetchEmpCount();
	public Boolean hasEmpId(int id);
	public Iterable<Employee> fetchAllEmps();
	public Iterable<Employee> fetchEmpsByIds(List<Integer> ids);
}
