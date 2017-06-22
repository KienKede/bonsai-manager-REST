package com.bonsaimanager.enums;

public enum RolesEnum {
	
	BASIC(1L, "ROLE_BASIC", "Basic User Role"),
	PRO(2L, "ROLE_PRO", "Pro User Role"),
	ADMIN(3L, "ROLE_ADMIN", "Admin User Role");
	
	private final Long id;
	
	private final String roleName;
	
	private final String roleDescription;
	
	RolesEnum(Long id, String roleName, String roleDescription){
		this.id = id;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}
	
	public Long getId(){
		return id;
	}
	
	public String getRoleName(){
		return roleName;
	}
	
	public String getRoleDescription(){
		return roleDescription;
	}

}

