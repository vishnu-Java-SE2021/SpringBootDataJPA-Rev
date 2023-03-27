//CRUDRepRunnerTest
package com.ltim.runner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ltim.entity.Employee;
import com.ltim.service.IEmployeeService;

@Component
public class CRUDRepRunnerTest implements CommandLineRunner {

	@Autowired
	private IEmployeeService empService;
	
	@Override
	public void run(String... args) throws Exception {

		Employee emp = new Employee();
		
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("Emp Name :: ");
			emp.setEname(sc.nextLine());
			
			System.out.print("Emp Dept :: ");
			emp.setDept(sc.nextLine());
			
			System.out.print("Emp Sal :: ");
			emp.setSal(sc.nextDouble());
			
			String result = empService.registerEmp(emp);
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}//run

}//class
