package com.frameworkonly.webapp.service;
/**
 * Created in Eclipse IDE.
 * Project : spring-mvc-jdbc-master
 * User: yash
 * Date: 18/01/2020
 */
import java.util.Collection;

import com.frameworkonly.webapp.domain.Employee;

public interface EmployeeServiceInterface {

	public Employee saveEmployee(Employee emp);
	public Boolean deleteEmployee(Long empId);
	public Employee editEmployee(Employee emp);
	public Employee findEmployee(Long empId);
	public Collection<Employee> getAllEmployees();
}
