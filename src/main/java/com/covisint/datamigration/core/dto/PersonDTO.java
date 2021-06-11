package com.covisint.datamigration.core.dto;

import java.util.List;

public class PersonDTO {
	
	private String realm;
	private String status;
	private String currency;
	private NameDTO name;
	private List<Address> addresses;
	private String language;
	private String timezone;
	private List<phone> phones;
	private String email;
	private ReferenceDTO organization;
	
	
	public String getRealm() {
		return realm;
	}
	public void setRealm(String realm) {
		this.realm = realm;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public NameDTO getName() {
		return name;
	}
	public void setName(NameDTO name) {
		this.name = name;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public List<phone> getPhones() {
		return phones;
	}
	public void setPhones(List<phone> phones) {
		this.phones = phones;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ReferenceDTO getOrganization() {
		return organization;
	}
	public void setOrganization(ReferenceDTO organization) {
		this.organization = organization;
	}

}
