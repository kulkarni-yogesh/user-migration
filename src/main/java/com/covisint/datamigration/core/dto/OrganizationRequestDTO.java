package com.covisint.datamigration.core.dto;

public class OrganizationRequestDTO {
	
	private ReferenceDTO registrant;
	private ReferenceDTO organization;
	private String justification;
	
	
	public ReferenceDTO getRegistrant() {
		return registrant;
	}
	public void setRegistrant(ReferenceDTO registrant) {
		this.registrant = registrant;
	}
	public ReferenceDTO getOrganization() {
		return organization;
	}
	public void setOrganization(ReferenceDTO organization) {
		this.organization = organization;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}

}
