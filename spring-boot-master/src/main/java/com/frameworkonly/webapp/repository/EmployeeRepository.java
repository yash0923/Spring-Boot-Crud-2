package com.frameworkonly.webapp.repository;
/**
 * Created in Eclipse IDE.
 * Project : spring-mvc-jdbc-master
 * User: yash
 * Date: 18/01/2020
 */
import org.springframework.data.repository.CrudRepository;

import com.frameworkonly.webapp.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	
}
