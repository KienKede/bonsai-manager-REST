package com.bonsaimanager.backend.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
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

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bonsaimanager.backend.converters.LocalDateTimeAttributeConverter;

/*
 * User Domain Class - 25/01/2017
 * id 				- 	id from the user          
 * username 		- 	username of the user
 * password 		- 	password of the user
 * email 			- 	email of the user
 * name				- 	name of the user
 * firstSurname		-	first surname of the user
 * secondSurname	-	second surname of the user	
 * phoneNumber		- 	phone number of the user
 * description 		-	description of the user
 * country			- 	country of the user
 * city				- 	city of the user
 * address			- 	address of the user
 * registrationDate	-	date of the user registration
 * profileImage		- 	profile image of the users
 * enabled			- 	is account enabled
 * visible			- 	is account public
 * birthDate		-	birth date of the user
 * 
 */
@Entity
@Table(name = "user")
public class User implements Serializable, UserDetails{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	
	@Column(unique = true)
	private String username;
	
	@NotNull
	@Column(nullable = false)
	private String password;
	
	@Column(unique = true)
	private String email;
	
	@Length(max = 50)
	private String name;
	
	@Column(name = "first_surname")
	@Length(max = 50)
	private String firstSurname;
	
	@Column(name = "second_surname")
	@Length(max = 50)
	private String secondSurname;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Length(max = 500)
	private String description;
	
	private String country;
	
	@Length(max = 50)
	private String city;
	
	@Length(max = 100)
	private String address;

	@Column(name = "profile_image")
	private String profileImage;
	
	@NotNull
	@Column(nullable = false)
	private boolean enabled;
	
	@NotNull
	@Column(nullable = false)
	private boolean visible;
	
	@NotNull
	@Column(nullable = false, name = "registration_date")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime registrationDate;
	
	@Column(name = "birth_date")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime birthDate;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<UserRole> userRoles = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<UserInteractsBonsai> userInteractsBonsai = new HashSet<>();
	
	public User(){
		
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		//userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		
		User user = (User) obj;
		return user.id == this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<UserInteractsBonsai> getUserInteractsBonsai() {
		return userInteractsBonsai;
	}

	public void setUserInteractsBonsai(Set<UserInteractsBonsai> userInteractsBonsai) {
		this.userInteractsBonsai = userInteractsBonsai;
	}
}