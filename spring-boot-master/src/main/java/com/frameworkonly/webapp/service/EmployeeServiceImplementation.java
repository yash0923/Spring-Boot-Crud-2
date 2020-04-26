package com.frameworkonly.webapp.service;
/**
 * Created in Eclipse IDE.
 * Project : spring-mvc-jdbc-master
 * User: yash
 * Date: 18/01/2020
 */
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frameworkonly.webapp.domain.Employee;
import com.frameworkonly.webapp.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeServiceInterface{

	@Autowired
	protected EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}

	@Override
	public Boolean deleteEmployee(Long empId) {
		// TODO Auto-generated method stub
		Employee temp = employeeRepository.findOne(empId);
		if(temp!=null){
			 employeeRepository.delete(temp);
			 return true;
		}
		return false;
	}

	@Override
	public Employee editEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp);
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		Iterable<Employee> itr = employeeRepository.findAll();
		return (Collection<Employee>)itr;
	}

	@Override
	public Employee findEmployee(Long empId) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(empId);
	}
	

}
