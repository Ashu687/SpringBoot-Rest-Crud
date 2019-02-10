package com.ashu.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.cruddemo.dao.EmployeeDao;
import com.ashu.cruddemo.entity.Employee;
import com.ashu.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService){
		this.employeeService = theEmployeeService;
	}
	
	//expose "/employee" and return list of employees
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeedID}")
	public Employee findById(@PathVariable int employeedID){
		Employee employee = employeeService.findById(employeedID);
		
		if(employee==null){
			throw new RuntimeException("there is no such employee exist with the id "+employeedID);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){
		employeeService.add(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee){
		employeeService.add(theEmployee);
		return theEmployee;
	}

	@DeleteMapping("/employees/{employeedID}")
	public String deleteById(@PathVariable int employeedID){
		Employee employee = employeeService.findById(employeedID);
		
		if(employee==null){
			throw new RuntimeException("there is no such employee exist with the id "+employeedID);
		}
		employeeService.deleteById(employeedID);
		
		return "Employee having id: "+employeedID+" has been deleted";
	}

}
