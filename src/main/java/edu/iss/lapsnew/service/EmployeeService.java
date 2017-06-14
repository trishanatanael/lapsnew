package edu.iss.lapsnew.service;

import java.util.ArrayList;

import edu.iss.lapsnew.model.Employee;

public interface EmployeeService {

	ArrayList<Employee> findEmployeesByManager(String s);

	Employee findEmployeeById(String s);

	ArrayList<Employee> findAllEmployees();

	Employee findEmployee(String empid);

	Employee createEmployee(Employee emp);

	Employee changeEmployee(Employee emp);

	void removeEmployee(Employee emp);
	
	ArrayList<String> findAllManagerNames();
	
	ArrayList<Employee> findAllManagers();

	ArrayList<Employee> findSubordinates(String employeeId);
	
	ArrayList<String> findAllEmployeeIDs();
	

}