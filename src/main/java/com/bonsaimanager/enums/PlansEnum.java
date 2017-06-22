package com.bonsaimanager.enums;

public enum PlansEnum {
	
	BASIC(1L, "BASIC", "Basic Plan"),
	PRO(2L, "PRO", "Pro Plan");

	private final Long id;
	
	private final String planName;
	
	private final String planDescription;
	
	PlansEnum(Long id, String planName, String planDescription){
		this.id = id;
		this.planName = planName;
		this.planDescription = planDescription;
	}
	
	public Long getId(){
		return id;
	}
	
	public String getPlanName(){
		return planName;
	}
	
	public String getPlanDescription(){
		return planDescription;
	}
}
