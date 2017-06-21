package com.bonsaimanager.backend.domain;

import org.springframework.security.core.GrantedAuthority;

/*
 * Authority Domain Class - 25/01/2017
 * authority	- 	authority access
 * 
 */
public class Authority implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	
	private final String authority;
	
	public Authority(String authority){
		this.authority = authority;
	}
	
	@Override
	public String getAuthority(){
		return authority;
	}
}