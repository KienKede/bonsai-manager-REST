package com.bonsaimanager.backend.domain;

import java.time.Clock;
import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.bonsaimanager.backend.converters.LocalDateTimeAttributeConverter;

@Entity
public class VerificationToken {
    private static final int EXPIRATION = 60 * 24;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    private String token;
   
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
     
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime expiryDate;
    
    private LocalDateTime calculateExpiryDate(int expiryTimeInMinutes) {
    	LocalDateTime expiryDate = LocalDateTime.now(Clock.systemUTC());
    	expiryDate.plusMinutes(EXPIRATION);
    	return expiryDate;
    }
     
    // standard constructors, getters and setters
    
    public VerificationToken(){
    	
    }
    
    public VerificationToken(String token, User user){
    	this.token = token;
    	this.user = user;
    	this.expiryDate = this.calculateExpiryDate(EXPIRATION);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}
}