package com.bonsaimanager.enums;

public enum PlansEnum {
	
	BASIC(1, "BASIC", "Basic Plan"),
	PRO(2, "PRO", "Pro Plan");

	private final int id;
	
	private final String planName;
	
	private final String planDescription;
	
	PlansEnum(int id, String planName, String planDescription){
		this.id = id;
		this.planName = planName;
		this.planDescription = planDescription;
	}
	
	public int getId(){
		return id;
	}
	
	public String getPlanName(){
		return planName;
	}
	
	public String getPlanDescription(){
		return planDescription;
	}
}
