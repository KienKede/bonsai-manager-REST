package com.bonsaimanager.enums;

public enum PrivilegesEnum {
	
	BASIC(1, "ROLE_BASIC", "Basic User Role"),
	PRO(2, "ROLE_PRO", "Pro User Role"),
	ADMIN(3, "ROLE_ADMIN", "Admin User Role");
	
	private final int id;
	
	private final String roleName;
	
	private final String roleDescription;
	
	PrivilegesEnum(int id, String roleName, String roleDescription){
		this.id = id;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}
	
	public int getId(){
		return id;
	}
	
	public String getRoleName(){
		return roleName;
	}
	
	public String getRoleDescription(){
		return roleDescription;
	}

}
