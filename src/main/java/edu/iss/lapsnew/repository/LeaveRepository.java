package edu.iss.lapsnew.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.lapsnew.model.Leavel;

public interface LeaveRepository extends JpaRepository<Leavel, Integer> {
	
	@Query("SELECT c from Leavel c WHERE c.employeeId = :eid")
	ArrayList<Leavel> findLeavesByEID(@Param("eid") String eid);
	
	@Query("SELECT c from Leavel c WHERE c.employeeId = :eid AND (c.status ='SUBMITTED' OR c.status ='UPDATED')")
	ArrayList<Leavel> findPendingLeavesByEID(@Param("eid") String eid);
	
	@Query(value = "SELECT * FROM course WHERE status = ?0", nativeQuery = true)
	ArrayList<Leavel> findPendingLeavesByStatus(String status);
	
	

}
