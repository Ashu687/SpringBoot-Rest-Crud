package com.ashu.cruddemo.dao;

import java.util.List;

import com.ashu.cruddemo.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void add(Employee employee);
	
	public void deleteById(int id);
}
