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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.bonsaimanager.backend.converters.LocalDateTimeAttributeConverter;
import com.bonsaimanager.common.persistence.model.IEntity;

@Entity
@Table(name = "pot")
public class Pot implements Serializable, IEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bonsai_id")
	private long id;
	
	@NotNull
	@Column(nullable = false)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime creation;
	
	@NotNull
	@Column(nullable = false)
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime register;
	
	@NotNull
	@Column(nullable = false)
	private boolean visible;
	
	@OneToMany(mappedBy = "pot", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<UserInteractsPot> userInteractsPot = new HashSet<>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
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
		Pot other = (Pot) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Set<UserInteractsPot> getUserInteractsPot() {
		return userInteractsPot;
	}

	public void setUserInteractsPot(Set<UserInteractsPot> userInteractsPot) {
		this.userInteractsPot = userInteractsPot;
	}
}
