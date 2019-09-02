package com.example.demo.controller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(value="/emp")
public class EmployeeController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {		
		this.employeeService = employeeService;
	}

	@CrossOrigin
	@GetMapping
	public List<Employee> getAllEmployeesList() {
		return employeeService.getEmployeesList();
	}
	
	@CrossOrigin
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {		
		employeeService.addEmployee(employee);
			return employee;
	}
	
	@CrossOrigin
	@DeleteMapping(path ={"/{id}"})
	public String deleteEmployee(@PathVariable("id") Integer id) {		
		employeeService.deleteEmployee(id);		
		return "Employee Deleted";
	}
	
	@CrossOrigin
	@PutMapping
	public String editEmployee(@RequestBody Employee employee) {
		employeeService.editEmployee(employee);		
		return "Employee Updated";
	}
	
}
