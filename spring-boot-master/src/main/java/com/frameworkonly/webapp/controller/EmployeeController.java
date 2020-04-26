package com.frameworkonly.webapp.controller;
/**
 * Created in Eclipse IDE.
 * Project : spring-mvc-jdbc-master
 * User: yash
 * Date: 18/01/2020
 */
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.frameworkonly.webapp.domain.Employee;
import com.frameworkonly.webapp.service.EmployeeServiceInterface;


@Controller
@ComponentScan
public class EmployeeController {

	@Autowired
	EmployeeServiceInterface employeeServiceInterface;
	
	@RequestMapping(value = {"/","/savepage"}, method = RequestMethod.GET)
	public String savePage(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("allEmployees", (ArrayList<Employee>)employeeServiceInterface.getAllEmployees());
		return "index";
	}
	
	@RequestMapping(value = {"/employee/save"}, method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			final RedirectAttributes redirectAttributes) {
		
		if(employeeServiceInterface.saveEmployee(employee)!=null) {
			redirectAttributes.addFlashAttribute("saveEmployee", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveEmployee", "unsuccess");
		}
		
		return "redirect:/savepage";
	}
	
	@RequestMapping(value = "/employee/{operation}/{empId}", method = RequestMethod.GET)
	public String editRemoveEmployee(@PathVariable("operation") String operation,
			@PathVariable("empId") Long empId, final RedirectAttributes redirectAttributes,
			Model model) {
		if(operation.equals("delete")) {
			if(employeeServiceInterface.deleteEmployee(empId)) {
				redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if(operation.equals("edit")){
		  Employee editEmployee = employeeServiceInterface.findEmployee(empId);
		  if(editEmployee!=null) {
		       model.addAttribute("editEmployee", editEmployee);
		       return "editPage";
		  } else {
			  redirectAttributes.addFlashAttribute("status","notfound");
		  }
		}
		
		return "redirect:/savepage";
	}
	
	@RequestMapping(value = "/employee/update", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("editEmployee") Employee editEmployee,
			final RedirectAttributes redirectAttributes) {
		if(employeeServiceInterface.editEmployee(editEmployee)!=null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}
		return "redirect:/savepage";
	}
}
