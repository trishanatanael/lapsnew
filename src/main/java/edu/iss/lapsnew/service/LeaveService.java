package edu.iss.lapsnew.service;

import java.util.ArrayList;

import edu.iss.lapsnew.model.Leavel;

public interface LeaveService {

	ArrayList<Leavel> findAllLeaves();

	Leavel findLeave(Integer ceid);

	Leavel createLeave(Leavel leave);

	Leavel changeLeave(Leavel leave);

	void removeLeave(Leavel leave);

	ArrayList<Leavel> findLeavesByEID(String eid);

	ArrayList<Leavel> findPendingLeavesByEID(String eid);

}