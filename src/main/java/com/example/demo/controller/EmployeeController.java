package com.example.demo.controller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping
	public List<Employee> getAllEmployeesList() {
		return employeeService.getEmployeesList();
	}
	
	@PostMapping
	public String addEmployee(@RequestBody Employee employee) {
		
		if(employeeService.addEmployee(employee))
			return "add successfully";
		return "not added";
	}
}
