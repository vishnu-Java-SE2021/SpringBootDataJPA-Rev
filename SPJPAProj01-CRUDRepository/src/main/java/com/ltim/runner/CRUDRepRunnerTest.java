//CRUDRepRunnerTest
package com.ltim.runner;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ltim.entity.Employee;
import com.ltim.service.IEmployeeService;

//@Component
public class CRUDRepRunnerTest implements CommandLineRunner {

	@Autowired
	private IEmployeeService empService;
	
	@Override
	public void run(String... args) throws Exception {

		/*
		 * Employee emp = new Employee();
		 * 
		 * try(Scanner sc = new Scanner(System.in)) { System.out.print("Emp Name :: ");
		 * emp.setEname(sc.nextLine());
		 * 
		 * System.out.print("Emp Dept :: "); emp.setDept(sc.nextLine());
		 * 
		 * System.out.print("Emp Sal :: "); emp.setSal(sc.nextDouble());
		 * 
		 * String result = empService.registerEmp(emp); System.out.println(result);
		 * }catch(Exception e) { e.printStackTrace(); }
		 */
		
		/*
		 * System.out.println("=============count()===========");
		 * System.out.println("No. of employees :: "+empService.fetchEmpCount());
		 * 
		 * System.out.println();
		 * System.out.println("============existsById()==========");
		 * System.out.println("Is emp with id-6 exists? "+ empService.hasEmpId(6));
		 */
		
		System.out.println("count :: "+empService.fetchEmpCount());
		System.out.println("===========findAll()=========");
//		
		Iterable<Employee> empList = empService.fetchAllEmps();
		
		/*
		 * for(Employee e : empList) { //enhanced for loop System.out.println(e); }
		 */
		
		/*
		 * empList.forEach(emp->{ //lambda exp + forEach method System.out.println(emp);
		 * });
		 */
		
//		empList.forEach(emp-> System.out.println(emp));
		
		empList.forEach(System.out::println);   //forEach + static method reference
	
		System.out.println("================findAllById(ids)=================");
		
//		List<Integer> ids = new ArrayList<>();
//		ids.add(6); ids.add(7);
//		
//		Iterable<Employee> empList = empService.fetchEmpsByIds(ids);   //mutable type
//		
//		empList.forEach(emp-> System.out.println(emp));
		
//		System.out.println(empService.fetchEmpsByIds(List.of(6,7)));    //Java 9v List factory method  --> immutable type
	
//		Iterable<Employee> empListWithIds = empService.fetchEmpsByIds(Arrays.asList(6,7));   //mutable type
//		empListWithIds.forEach(System.out::println);
		
		
		System.out.println("================findById(id)=================");
		
		/*
		 * try {
		 * System.out.println("Employee with id-8 :: "+empService.fetchEmpById(9)); }
		 * catch(Exception e) { e.printStackTrace(); }
		 */
		
		try {
			Optional<Employee> opt = empService.searchEmpById(6);
			
			if(opt.isEmpty())
				throw new IllegalArgumentException("No record found");
			else
				System.out.println(opt.get());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("==================saveAll()================");
		
		System.out.println(empService.registerAllEmps(List.of(
																							new Employee("Rolex","IT",30000.0),
																							new Employee("Dilli","HR",40000.0),
																							new Employee("Vikram","Finance",50000.0))));
	}//run

}//class
