package edu.iss.lapsnew.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.iss.lapsnew.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
	
	@Query("SELECT d.departmentId FROM Department d")
	ArrayList<String> findDepartmentNames();

}
