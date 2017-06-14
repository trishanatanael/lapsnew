package edu.iss.lapsnew.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.lapsnew.model.Employee;
import edu.iss.lapsnew.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeRepository employeeRepository;

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.EmployeeService#findEmployeesByManager(java.lang.String)
	 */
	@Override
	@Transactional
	public ArrayList<Employee> findEmployeesByManager(String s) {
		return employeeRepository.findEmployeesByManagerId(s);
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.EmployeeService#findEmployeeById(java.lang.String)
	 */
	@Override
	@Transactional
	public Employee findEmployeeById(String s) {
		return employeeRepository.findEmployeeById(s);
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.EmployeeService#findAllEmployees()
	 */
	@Override
	@Transactional
	public ArrayList<Employee> findAllEmployees() {
		ArrayList<Employee> l = (ArrayList<Employee>) employeeRepository.findAll();
		return l;
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.EmployeeService#findEmployee(java.lang.String)
	 */
	@Override
	@Transactional
	public Employee findEmployee(String empid) {
		return employeeRepository.findOne(empid);

	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.EmployeeService#createEmployee(edu.iss.lapsnew.model.Employee)
	 */
	@Override
	@Transactional
	public Employee createEmployee(Employee emp) {
		return employeeRepository.saveAndFlush(emp);
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.EmployeeService#changeEmployee(edu.iss.lapsnew.model.Employee)
	 */
	@Override
	@Transactional
	public Employee changeEmployee(Employee emp) {
		return employeeRepository.saveAndFlush(emp);
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.EmployeeService#removeEmployee(edu.iss.lapsnew.model.Employee)
	 */
	@Override
	@Transactional
	public void removeEmployee(Employee emp) {
		employeeRepository.delete(emp);
	}
	
	@Transactional
	public ArrayList<String> findAllManagerNames() {
		return employeeRepository.findAllManagerNames();
	}
	
	@Transactional
	public ArrayList<Employee> findAllManagers() {
		return employeeRepository.findAllManagers();
	}

	@Override
	public ArrayList<Employee> findSubordinates(String employeeId) {
		return employeeRepository.findSubordinates(employeeId);
	}

	@Override
	public ArrayList<String> findAllEmployeeIDs() {
		return employeeRepository.findAllEmployeeIDs();
	}


}
