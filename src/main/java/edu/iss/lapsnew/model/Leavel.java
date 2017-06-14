
package edu.iss.lapsnew.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

/**
 * Leavel class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "leavel", schema = "laps_db_new")
public class Leavel {

	public static final String SUBMITTED = "SUBMITTED";
	public static final String APPROVED = "APPROVED";
	public static final String WITHDRAWN = "WITHDRAWN";
	public static final String UPDATED = "UPDATED";
	public static final String REJECTED = "REJECTED";

	/** Attributes for Leavel **/
	@Id
	@Column(name = "leaveid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;
	@Basic
	@Column(name = "employeeid")
	private String employeeId;
	@Column(name = "leavename")
	private String leaveName;
	@Column(name = "organiser")
	private String organiser;
	@Temporal(TemporalType.DATE)
	@Column(name = "fromdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "todate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date toDate;
	@Column(name = "justification")
	private String justification;
	@Column(name = "status")
	private String status;

	/** Container for LeaveApplicationActions **/
	@OneToMany(mappedBy="leavel", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<LeaveEvent> leaveEvent = new ArrayList<LeaveEvent>();

	public Leavel() {
	}

	public Leavel(int leaveId) {
		this.leaveId = leaveId;
	}

	public Leavel(int leaveId, String employeeId, String leaveName, String organiser, Date fromDate, Date toDate,
			String justification, String status, ArrayList<LeaveEvent> events) {
		super();
		this.leaveId = leaveId;
		this.employeeId = employeeId;
		this.leaveName = leaveName;
		this.organiser = organiser;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.justification = justification;
		this.status = status;
		this.leaveEvent.addAll(leaveEvent);
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getLeaveName() {
		return leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}

	public String getOrganiser() {
		return organiser;
	}

	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<LeaveEvent> getEvents() {
		 return (new ArrayList<LeaveEvent>(leaveEvent));
	}

	public void setEvents(ArrayList<LeaveEvent> events) {
		this.leaveEvent.addAll(leaveEvent);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leaveId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leavel other = (Leavel) obj;
		if (leaveId != other.leaveId)
			return false;
		return true;
	}

	

}