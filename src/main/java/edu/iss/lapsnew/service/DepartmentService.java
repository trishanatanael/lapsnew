package edu.iss.lapsnew.service;

import java.util.ArrayList;

import edu.iss.lapsnew.model.Department;

public interface DepartmentService {

	ArrayList<Department> findAllDepartments();

	Department findDepartment(String did);

	Department createDepartment(Department dep);

	Department changeDepartment(Department dep);

	void removeDepartment(Department dep);

}