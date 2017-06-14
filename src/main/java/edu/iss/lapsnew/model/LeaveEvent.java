
package edu.iss.lapsnew.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LeaveEvent class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "leaveevent", schema = "laps_db_new")
public class LeaveEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leaveeventid")
	private int leaveEventId;
	@Temporal(TemporalType.DATE)
	@Column(name = "timestamp")
	private Date timeStamp;
	@Column(name = "eventtype")
	private String eventType;
	@Column(name = "eventby")
	private String eventBy;
	@Column(name = "comment")
	private String comment;
	// Reverse Relation
	@ManyToOne
	@JoinColumn(name = "leaveid")
	private Leavel leavel;

	public LeaveEvent() {
	}

	public LeaveEvent(int leaveEventId, Date timeStamp, String eventType, String eventBy, String comment,
			Leavel leavel) {
		super();
		this.leaveEventId = leaveEventId;
		this.timeStamp = timeStamp;
		this.eventType = eventType;
		this.eventBy = eventBy;
		this.comment = comment;
		this.leavel = leavel;
	}

	public int getLeaveEventId() {
		return leaveEventId;
	}

	public void setLeaveEventId(int leaveEventId) {
		this.leaveEventId = leaveEventId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventBy() {
		return eventBy;
	}

	public void setEventBy(String eventBy) {
		this.eventBy = eventBy;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Leavel getLeave() {
		return leavel;
	}

	public void setLeave(Leavel leavel) {
		this.leavel = leavel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leaveEventId;
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
		LeaveEvent other = (LeaveEvent) obj;
		if (leaveEventId != other.leaveEventId)
			return false;
		return true;
	}

	
}