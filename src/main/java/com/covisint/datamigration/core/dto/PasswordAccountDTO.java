package com.covisint.datamigration.core.dto;

public class PasswordAccountDTO {
	
	private String username;
	private String password;
	private ReferenceDTO passwordPolicy;
	private ReferenceDTO authenticationPolicy;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ReferenceDTO getPasswordPolicy() {
		return passwordPolicy;
	}
	public void setPasswordPolicy(ReferenceDTO passwordPolicy) {
		this.passwordPolicy = passwordPolicy;
	}
	public ReferenceDTO getAuthenticationPolicy() {
		return authenticationPolicy;
	}
	public void setAuthenticationPolicy(ReferenceDTO authenticationPolicy) {
		this.authenticationPolicy = authenticationPolicy;
	}
	
}
