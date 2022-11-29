package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="email", unique=true, nullable=false)
	@Size(max = 45)
	private String email;
	
	@Column(name="password", nullable=false)
	@Size(max = 45)
	private String password;
	
	private boolean enabled;
	
	@Size(max = 45)
	private String role;
	
	

	public Usuario() {
		super();
	}

	public Usuario(long id, String email, @Size(max = 45) String password, boolean enabled, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
