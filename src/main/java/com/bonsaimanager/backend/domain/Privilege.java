package com.bonsaimanager.backend.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bonsaimanager.enums.PrivilegesEnum;

/*
 * Role Domain Class - 25/01/2017
 * id 		- 	id of the role
 * name 	- 	name of the role
 * 
 */
@Entity
@Table(name = "privilege")
public class Privilege implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "privilege_id")
	private long id;
	
	private String name;
	
	private String description;

	@OneToMany(mappedBy = "privilege", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RolePrivilege> rolePrivileges = new HashSet<>();
	
	public Privilege(){
		
	}
	
	public Privilege(PrivilegesEnum privilegesEnum){
		this.id = privilegesEnum.getId();
		this.name = privilegesEnum.getRoleName();
		this.description = privilegesEnum.getRoleDescription();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<RolePrivilege> getRolePrivileges() {
		return rolePrivileges;
	}

	public void setRolePrivileges(Set<RolePrivilege> rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rolePrivileges == null) ? 0 : rolePrivileges.hashCode());
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
		Privilege other = (Privilege) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rolePrivileges == null) {
			if (other.rolePrivileges != null)
				return false;
		} else if (!rolePrivileges.equals(other.rolePrivileges))
			return false;
		return true;
	}

}

