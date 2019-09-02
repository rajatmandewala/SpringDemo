package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {		
		this.employeeRepository = employeeRepository;
	}	
	
	public List<Employee> getEmployeesList(){		
		return employeeRepository.findAll();
	}
	
	public boolean addEmployee(Employee employee) {
		if(employeeRepository.save(employee)!=null)
			return true;
		return false;
	}	
	
	public boolean deleteEmployee(Integer id) {
		Employee employee=employeeRepository.findById(id).get();
		if(employee!=null)		
		employeeRepository.delete(employee);		
		return true;
	}
	
	public boolean editEmployee(Employee employee) {		
		Employee emp=employeeRepository.findById(employee.getId()).get();
		if(emp!=null)
			employeeRepository.save(employee);		
		return true;
	}
}
