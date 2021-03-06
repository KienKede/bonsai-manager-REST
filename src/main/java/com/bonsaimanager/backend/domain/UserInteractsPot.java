package com.bonsaimanager.backend.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.bonsaimanager.backend.converters.LocalDateTimeAttributeConverter;
import com.bonsaimanager.common.persistence.model.IEntity;

@Entity
@Table(name = "user_interacts_pot")
public class UserInteractsPot implements Serializable, IEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_interacts_bonsai_id")
	private long id;
	
	@NotNull
	@Column(nullable = false)
	private boolean edit;
	
	@NotNull
	@Column(nullable = false, name = "interaction_value")
	private String interactionValue;
	
	@NotNull
	@Column(nullable = false, name = "interaction_date")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime interactionDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pot_id")
	private Pot pot;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "interaction_kind_id")
	private InteractionKind interactionKind;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getInteractionValue() {
		return interactionValue;
	}

	public void setInteractionValue(String interactionValue) {
		this.interactionValue = interactionValue;
	}

	public LocalDateTime getInteractionDate() {
		return interactionDate;
	}

	public void setInteractionDate(LocalDateTime interactionDate) {
		this.interactionDate = interactionDate;
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
		UserInteractsPot other = (UserInteractsPot) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Pot getPot() {
		return pot;
	}

	public void setPot(Pot pot) {
		this.pot = pot;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public InteractionKind getInteractionKind() {
		return interactionKind;
	}

	public void setInteractionKind(InteractionKind interactionKind) {
		this.interactionKind = interactionKind;
	}
}
