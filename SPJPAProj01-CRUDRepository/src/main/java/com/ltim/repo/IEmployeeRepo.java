//IEmployeeRepo.java
package com.ltim.repo;

import org.springframework.data.repository.CrudRepository;

import com.ltim.entity.Employee;

public interface IEmployeeRepo extends CrudRepository<Employee, Integer> {

}
