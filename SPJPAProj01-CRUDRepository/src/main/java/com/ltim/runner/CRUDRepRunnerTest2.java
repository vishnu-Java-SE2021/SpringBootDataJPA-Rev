//CRUDRepRunnerTest
package com.ltim.runner;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ltim.entity.Employee;
import com.ltim.service.IEmployeeService;

@Component
public class CRUDRepRunnerTest2 implements CommandLineRunner {

	@Autowired
	private IEmployeeService empService;
	
	@Override
	public void run(String... args) throws Exception {
		
		//=====================update============================
		/*
		 * try { System.out.println(empService.updateEmpDetails(24, "IT", 45000.0)); }
		 * catch(Exception e) { e.printStackTrace(); }
		 */
		
		try {
//			System.out.println(empService.updateEmp(new Employee(21,"Finance","LEO",40000.0)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//========================delete============================
		//deleting record by passing entity object
		try {
//			System.out.println(empService.removeEmp(new Employee(23,"","",0.0)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//deleting record by passing pk column value
		try {
//			System.out.println(empService.removeEmpById(22));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		//deleting records by passing list of pk column values
		try {
			System.out.println(empService.removeEmpsByIds(List.of(24,25,26)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//run

}//class
