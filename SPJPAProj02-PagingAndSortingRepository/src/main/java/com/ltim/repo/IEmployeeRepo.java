//IEmployeeRepo.java
package com.ltim.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ltim.entity.Employee;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee, Integer> {

}
