package com.bonsaimanager.enums;

public enum InteractionKindEnum {
	
	OWNS(1, "OWNS", "User owns"),
	LIKE(2, "LIKE", "Like interaction"),
	DISLIKE(3, "DISLIKE", "Dislike interaction"),
	COMMENT(4, "COMMENT", "Comment interaction"),
	REPLY(5, "REPLY", "A comment reply interaction");
	
	private final int id;
	
	private final String interactionName;
	
	private final String interactionDescription;
	
	InteractionKindEnum(int id, String interactionName, String interactionDescription){
		this.id = id;
		this.interactionName = interactionName;
		this.interactionDescription = interactionDescription;
	}
	
	public int getId(){
		return id;
	}
	
	public String getInteractionName(){
		return interactionName;
	}
	
	public String getInteractionDescription(){
		return interactionDescription;
	}
}
