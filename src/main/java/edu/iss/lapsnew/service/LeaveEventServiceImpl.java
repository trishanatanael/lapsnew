package edu.iss.lapsnew.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.lapsnew.model.LeaveEvent;
import edu.iss.lapsnew.repository.LeaveEventRepository;

@Service
public class LeaveEventServiceImpl implements LeaveEventService {
	
	@Resource
	private LeaveEventRepository leaveEventRepository;
	

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveEventService#findAllLeaveEvents()
	 */
	@Override
	@Transactional
	public ArrayList<LeaveEvent> findAllLeaveEvents() {
		ArrayList<LeaveEvent> l = (ArrayList<LeaveEvent>) leaveEventRepository.findAll();
		return l;
	}


	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveEventService#findLeaveEvent(java.lang.String)
	 */
	@Override
	@Transactional
	public LeaveEvent findLeaveEvent(Integer ceid) {
		return leaveEventRepository.findOne(ceid);

	}

	
	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveEventService#createLeaveEvent(edu.iss.lapsnew.model.LeaveEvent)
	 */
	@Override
	@Transactional
	public LeaveEvent createLeaveEvent(LeaveEvent leaveEvent) {
		return leaveEventRepository.saveAndFlush(leaveEvent);
	}

	
	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveEventService#changeLeaveEvent(edu.iss.lapsnew.model.LeaveEvent)
	 */
	@Override
	@Transactional
	public LeaveEvent changeLeaveEvent(LeaveEvent leaveEvent) {
		return leaveEventRepository.saveAndFlush(leaveEvent);
	}

	/* (non-Javadoc)
	 * @see edu.iss.lapsnew.service.LeaveEventService#removeLeaveEvent(edu.iss.lapsnew.model.LeaveEvent)
	 */
	@Override
	@Transactional
	public void removeLeaveEvent(LeaveEvent leaveEvent) {
		leaveEventRepository.delete(leaveEvent);
	}

}
