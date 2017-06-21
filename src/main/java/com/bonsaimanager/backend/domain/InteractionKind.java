package com.bonsaimanager.backend.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "interaction_kind")
public class InteractionKind implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "interaction_kind_id")
	private long id;
	
	@NotNull
	@Column(nullable = false, name = "interaction_name")
	private String interactionName;
	
	@NotNull
	@Column(nullable = false, name = "interaction_description")
	private String interactionDescription;
	
	@OneToMany(mappedBy = "interactionKind", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserInteractsBonsai> userInteractsBonsai = new HashSet<>();
	
	@OneToMany(mappedBy = "interactionKind", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserInteractsPot> userInteractsPot = new HashSet<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInteractionName() {
		return interactionName;
	}

	public void setInteractionName(String interactionName) {
		this.interactionName = interactionName;
	}

	public String getInteractionDescription() {
		return interactionDescription;
	}

	public void setInteractionDescription(String interactionDescription) {
		this.interactionDescription = interactionDescription;
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
		InteractionKind other = (InteractionKind) obj;
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

	public Set<UserInteractsPot> getUserInteractsPot() {
		return userInteractsPot;
	}

	public void setUserInteractsPot(Set<UserInteractsPot> userInteractsPot) {
		this.userInteractsPot = userInteractsPot;
	}
	
}
