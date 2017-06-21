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

import com.bonsaimanager.backend.domain.Role;
import com.bonsaimanager.backend.domain.UserRole;
import com.bonsaimanager.enums.RolesEnum;

/*
 * Role Domain Class - 25/01/2017
 * id 		- 	id of the role
 * name 	- 	name of the role
 * 
 */
@Entity
@Table(name = "role")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "role_id")
	private int id;
	
	private String name;
	
	private String description;

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserRole> userRoles = new HashSet<>();
	
	public Role(){
		
	}
	
	public Role(RolesEnum rolesEnum){
		this.id = rolesEnum.getId();
		this.name = rolesEnum.getRoleName();
		this.description = rolesEnum.getRoleDescription();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Role role = (Role) obj;
		return role.id == this.id;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
