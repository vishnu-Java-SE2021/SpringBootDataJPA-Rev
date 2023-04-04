package com.ltim.service;

import org.springframework.data.domain.Page;

import com.ltim.entity.Employee;

public interface IEmployeeService {

	public Iterable<Employee> getEmpsByOrder(Boolean order, String... props);
	public Page<Employee> generateEmployeeReport(int pageNo, int pageSize);
}
