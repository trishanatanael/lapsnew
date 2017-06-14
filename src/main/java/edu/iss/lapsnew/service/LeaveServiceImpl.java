package edu.iss.lapsnew.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.lapsnew.model.Leavel;
import edu.iss.lapsnew.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService {
	
	@Resource
	private LeaveRepository courseRepository;
	

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveService#findAllLeaves()
	 */
	@Override
	@Transactional
	public ArrayList<Leavel> findAllLeaves() {
		ArrayList<Leavel> l = (ArrayList<Leavel>) courseRepository.findAll();
		return l;
	}


	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveService#findLeave(java.lang.String)
	 */
	@Override
	@Transactional
	public Leavel findLeave(Integer ceid) {
		return courseRepository.findOne(ceid);

	}

	
	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveService#createLeave(edu.iss.lapsnew.model.Leavel)
	 */
	@Override
	@Transactional
	public Leavel createLeave(Leavel course) {
		return courseRepository.saveAndFlush(course);
	}

	
	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveService#changeLeave(edu.iss.lapsnew.model.Leavel)
	 */
	@Override
	@Transactional
	public Leavel changeLeave(Leavel course) {
		return courseRepository.saveAndFlush(course);
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveService#removeLeave(edu.iss.lapsnew.model.Leavel)
	 */
	@Override
	@Transactional
	public void removeLeave(Leavel course) {
		courseRepository.delete(course);
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveService#findLeavesByEID(java.lang.String)
	 */
	@Override
	@Transactional
	public ArrayList<Leavel> findLeavesByEID(String eid) {
		return courseRepository.findLeavesByEID(eid);
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveService#findPendingLeavesByEID(java.lang.String)
	 */
	@Override
	@Transactional
	public ArrayList<Leavel> findPendingLeavesByEID(String eid) {
		return courseRepository.findPendingLeavesByEID(eid);
	}
}
