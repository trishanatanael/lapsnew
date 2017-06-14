
package edu.iss.lapsnew.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Leavel class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "role", schema = "laps_db_new")
public class Role {
	@Id
	@Column(name = "roleid")
	private String roleId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
		public Role() {
	}
   // @OneToOne
   // @JoinColumn()
    //private Customer customer;
	public Role(String roleId, String name, String description) {

		this.roleId = roleId;
		this.name = name;
		this.description = description;

	}

	public Role(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		Role other = (Role) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}


	
	

}