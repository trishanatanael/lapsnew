package edu.iss.lapsnew.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.lapsnew.model.Department;
import edu.iss.lapsnew.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Resource
	private DepartmentRepository departmentRepository;
	
	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.DepartmentService#findAllDepartments()
	 */
	@Override
	@Transactional
	public ArrayList<Department> findAllDepartments() {
		ArrayList<Department> l = (ArrayList<Department>) departmentRepository.findAll();
		return l;
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.DepartmentService#findDepartment(java.lang.String)
	 */
	@Override
	@Transactional
	public Department findDepartment(String did) {
		return departmentRepository.findOne(did);

	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.DepartmentService#createDepartment(edu.iss.lapsnew.model.Department)
	 */
	@Override
	@Transactional
	public Department createDepartment(Department dep) {
		return departmentRepository.saveAndFlush(dep);
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.DepartmentService#changeDepartment(edu.iss.lapsnew.model.Department)
	 */
	@Override
	@Transactional
	public Department changeDepartment(Department dep) {
		return departmentRepository.saveAndFlush(dep);
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.DepartmentService#removeDepartment(edu.iss.lapsnew.model.Department)
	 */
	@Override
	@Transactional
	public void removeDepartment(Department dep) {
		departmentRepository.delete(dep);
	}

}
