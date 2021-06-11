package com.covisint.datamigration.core.dto;


public class UsersDTO {

	private PersonDTO person;
	private PasswordAccountDTO passwordAccount;
	private String creator;
	private Integer creation;
	private String realm;
	private Integer expiration;
	//private boolean locked;
	private String locked;
	private Integer unlockInstant;
	private SecurityQuestionAccountDTO securityQuestionAccount;
	
	
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	public String getRealm() {
		return realm;
	}
	public void setRealm(String realm) {
		this.realm = realm;
	}
	public PasswordAccountDTO getPasswordAccount() {
		return passwordAccount;
	}
	public void setPasswordAccount(PasswordAccountDTO passwordAccount) {
		this.passwordAccount = passwordAccount;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getCreation() {
		return creation;
	}
	public void setCreation(Integer creation) {
		this.creation = creation;
	}
	public Integer getExpiration() {
		return expiration;
	}
	public void setExpiration(Integer expiration) {
		this.expiration = expiration;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	// Currently Person Registration API is stringifying locked property
	/*public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}*/
	public Integer getUnlockInstant() {
		return unlockInstant;
	}
	public void setUnlockInstant(Integer unlockInstant) {
		this.unlockInstant = unlockInstant;
	}
	public SecurityQuestionAccountDTO getSecurityQuestionAccount() {
		return securityQuestionAccount;
	}
	public void setSecurityQuestionAccount(SecurityQuestionAccountDTO securityQuestionAccount) {
		this.securityQuestionAccount = securityQuestionAccount;
	}
}
