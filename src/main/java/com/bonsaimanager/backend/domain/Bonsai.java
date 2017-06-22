package com.bonsaimanager.backend.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.bonsaimanager.backend.converters.LocalDateTimeAttributeConverter;
import com.bonsaimanager.common.persistence.model.IEntity;

/*
 * Bonsai Domain Class - 29/01/2017
 * id 				- 	id from the bonsai
 * birth	 		- 	bonsai birth date
 * register 		- 	bonsai registration date
 * visible			- 	is bonsai public
 * 
 */
@Entity
public class Bonsai implements Serializable, IEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bonsai_id")
	private long id;
	
	@NotNull
	@Column(nullable = false)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime birth;
	
	@NotNull
	@Column(nullable = false)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime register;
	
	@NotNull
	@Column(nullable = false)
	private boolean visible;
	
	@OneToMany(mappedBy = "bonsai", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<UserInteractsBonsai> userInteractsBonsai = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getBirth() {
		return birth;
	}

	public void setBirth(LocalDateTime birth) {
		this.birth = birth;
	}

	public LocalDateTime getRegister() {
		return register;
	}

	public void setRegister(LocalDateTime register) {
		this.register = register;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Bonsai other = (Bonsai) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Set<UserInteractsBonsai> getUserInteractsBonsai() {
		return userInteractsBonsai;
	}

	public void setUserInteractsBonsai(Set<UserInteractsBonsai> userInteractsBonsai) {
		this.userInteractsBonsai = userInteractsBonsai;
	}

}
