package edu.iss.lapsnew.service;

import java.util.ArrayList;

import edu.iss.lapsnew.model.LeaveEvent;

public interface LeaveEventService {

	ArrayList<LeaveEvent> findAllLeaveEvents();

	LeaveEvent findLeaveEvent(Integer ceid);

	LeaveEvent createLeaveEvent(LeaveEvent courseEvent);

	LeaveEvent changeLeaveEvent(LeaveEvent courseEvent);

	void removeLeaveEvent(LeaveEvent courseEvent);

}