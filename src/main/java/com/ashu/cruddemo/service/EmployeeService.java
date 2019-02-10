package com.ashu.cruddemo.service;

import java.util.List;

import com.ashu.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void add(Employee employee);

	public void deleteById(int id);

}
