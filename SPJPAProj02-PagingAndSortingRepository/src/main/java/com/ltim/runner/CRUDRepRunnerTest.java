//CRUDRepRunnerTest
package com.ltim.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.ltim.entity.Employee;
import com.ltim.service.IEmployeeService;

@Component
public class CRUDRepRunnerTest implements CommandLineRunner {

	@Autowired
	private IEmployeeService empService;
	
	@Override
	public void run(String... args) throws Exception {


		System.out.println("=====================sorting==================");
	
		Iterable<Employee> empList = empService.getEmpsByOrder(true,"ename");
		empList.forEach(System.out::println);
		
		//priority order for sorting
		//1. Special characters
		//2. Numbers
		//3. Uppercase
		//4. lowercase
		
		System.out.println("=================paging=================");
		Page<Employee> page = empService.generateEmployeeReport(2, 2);
		
		List<Employee> empReport = page.getContent();
		empReport.forEach(System.out::println);
	}//run

}//class
