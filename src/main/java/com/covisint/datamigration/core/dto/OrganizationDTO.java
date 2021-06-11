package com.covisint.datamigration.core.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class OrganizationDTO {
	
	private String id;
	private String version;
	private String creator;
	private String status;
	private ReferenceDTO parentOrganization;
	private ReferenceDTO rootOrganization;
	private String name;
	private List<Address> addresses;
	private List<phone> phones;
	private String email;
	private String url;
	private String authDomain;
	private String organizationType;
	private String organizationSubtype;
	private String accountNumber;
	private String externalCode;
	private String duns;
	private String classification;
	@SerializedName("public")
	private boolean isPublic;
	private ReferenceDTO passwordPolicy;
	private ReferenceDTO authenticationPolicy;
	private List<Attributes> attributes;
	
	
	public OrganizationDTO() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ReferenceDTO getParentOrganization() {
		return parentOrganization;
	}
	public void setParentOrganization(ReferenceDTO parentOrganization) {
		this.parentOrganization = parentOrganization;
	}
	public ReferenceDTO getRootOrganization() {
		return rootOrganization;
	}
	public void setRootOrganization(ReferenceDTO rootOrganization) {
		this.rootOrganization = rootOrganization;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAuthDomain() {
		return authDomain;
	}
	public void setAuthDomain(String authDomain) {
		this.authDomain = authDomain;
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
	public String getOrganizationSubtype() {
		return organizationSubtype;
	}
	public void setOrganizationSubtype(String organizationSubtype) {
		this.organizationSubtype = organizationSubtype;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getExternalCode() {
		return externalCode;
	}
	public void setExternalCode(String externalCode) {
		this.externalCode = externalCode;
	}
	public String getDuns() {
		return duns;
	}
	public void setDuns(String duns) {
		this.duns = duns;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
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
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public List<Attributes> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<Attributes> attributes) {
		this.attributes = attributes;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	
}
