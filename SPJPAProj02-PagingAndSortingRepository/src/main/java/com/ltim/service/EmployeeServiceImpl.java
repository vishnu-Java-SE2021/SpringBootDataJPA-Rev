package com.ltim.service;

import java.util.ArrayList; 
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ltim.entity.Employee;
import com.ltim.repo.IEmployeeRepo;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public Iterable<Employee> getEmpsByOrder(Boolean order, String... props) {

		Sort sort = Sort.by(order? Direction.ASC : Direction.DESC , props);
		
		return empRepo.findAll(sort);
	}

	@Override
	public Page<Employee> generateEmployeeReport(int pageNo, int pageSize) {
		Pageable pg = PageRequest.of(pageNo, pageSize);
		
		return empRepo.findAll(pg);
	}
	
	

}
