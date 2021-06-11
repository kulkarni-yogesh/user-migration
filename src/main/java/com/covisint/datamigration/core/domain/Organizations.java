package com.covisint.datamigration.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORGANIZATIONS")
public class Organizations {

	@Id
	@Column(name = "ORGANIZATION_ID")
	private Long id;
	
	@Column(name="PARENT_ORGANIZATION_ID")
	private Long parentOrgId;
	
	@Column(name="ORGANIZATION_NAME")
	private String orgName;
	
	@Column(name="DUNS_NUMBER")
	private String dunsNumber;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="FAX")
	private String fax;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	
	@Column(name="ADDRESS1")
	private String address1;
	
	@Column(name="ADDRESS2")
	private String address2;
   
	@Column(name="ADDRESS3")
	private String address3;

	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
   
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="TOP_ORGANIZATION_ID")
	private Long topOrgId;
	
	@Column(name="STATUS_ENUM")
	private Integer statusEnum;
   
	@Column(name="LAST_STATUS_ID")
	private Integer lastStatusId;
      
	@Column(name="LAST_UPD_SSO_ID")
	private String lastUpdSsoId;
	
	@Column(name="LAST_UPD_DT")
	private Date lastUpdDate;
   
	@Column(name="HAS_CMA")
	private String hasCMA;
      
	@Column(name="CMA_SSO_USER_ID")
	private String cmaSsoUserId;
   
	@Column(name="CMA_DATE")
	private Date cmaDate;
       
	@Column(name="LAST_UPD_USER_ID")
	private Long lastUpdUserId;
      
	@Column(name="IS_REQUEST_REASON_RQRD")
	private String isReqReasonRqrd;
   
	@Column(name="CREATOR_ID")
	private Long creatorId;
	
	@Column(name="ORG_CLASSIFICATION")
	private String OrgClassification;
      
	@Column(name="ORGANIZATION_TYPE")
	private String OrgType;
   
	@Column(name="ORG_SUB_TYPE")
	private Integer orgSubType;
 
	@Column(name="AUTH_DOMAIN")
	private String authDomain;
      
	@Column(name="IS_PUBLIC")
	private String isPublic;
   
	@Column(name="ACCOUNT_NUMBER")
	private Integer accountNumber;
	  
	@Column(name="REALM_CODE")
	private String realmCode;
      
	@Column(name="EXTERNAL_ORG_CODE")
	private String externalOrgCode;
   
	@Column(name="EMAIL")
	private String email;

	@Column(name="GBL_COV_ORG_ID")
	private String gblCovOrgId;
      
	@Column(name="PASSWORD_POLICY_ID")
	private String pwdPolicyId;
   
	@Column(name="AUTHN_POLICY_ID")
	private String authnPolicyId;
	 
	@Column(name="IS_REQUEST_REASON_SAO_RQRD")
	private String isReqReasonSaoReqd;
   
	@Column(name="IS_REQUEST_REASON_SAO_DESC")
	private String isReqReasonSaoDesc;
	
	public Organizations() {
		
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getParentOrgId() {
		return parentOrgId;
	}



	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}



	public void setTopOrgId(Long topOrgId) {
		this.topOrgId = topOrgId;
	}



	public void setLastUpdUserId(Long lastUpdUserId) {
		this.lastUpdUserId = lastUpdUserId;
	}



	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}



	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDunsNumber() {
		return dunsNumber;
	}

	public void setDunsNumber(String dunsNumber) {
		this.dunsNumber = dunsNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getStatusEnum() {
		return statusEnum;
	}

	public void setStatusEnum(Integer statusEnum) {
		this.statusEnum = statusEnum;
	}

	public Integer getLastStatusId() {
		return lastStatusId;
	}

	public void setLastStatusId(Integer lastStatusId) {
		this.lastStatusId = lastStatusId;
	}

	public String getLastUpdSsoId() {
		return lastUpdSsoId;
	}

	public void setLastUpdSsoId(String lastUpdSsoId) {
		this.lastUpdSsoId = lastUpdSsoId;
	}

	public Date getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

	public String getHasCMA() {
		return hasCMA;
	}

	public void setHasCMA(String hasCMA) {
		this.hasCMA = hasCMA;
	}

	public String getCmaSsoUserId() {
		return cmaSsoUserId;
	}

	public void setCmaSsoUserId(String cmaSsoUserId) {
		this.cmaSsoUserId = cmaSsoUserId;
	}

	public Date getCmaDate() {
		return cmaDate;
	}

	public void setCmaDate(Date cmaDate) {
		this.cmaDate = cmaDate;
	}

	public String getIsReqReasonRqrd() {
		return isReqReasonRqrd;
	}

	public void setIsReqReasonRqrd(String isReqReasonRqrd) {
		this.isReqReasonRqrd = isReqReasonRqrd;
	}

	public String getOrgClassification() {
		return OrgClassification;
	}

	public void setOrgClassification(String orgClassification) {
		OrgClassification = orgClassification;
	}

	public String getOrgType() {
		return OrgType;
	}

	public void setOrgType(String orgType) {
		OrgType = orgType;
	}

	public Integer getOrgSubType() {
		return orgSubType;
	}

	public void setOrgSubType(Integer orgSubType) {
		this.orgSubType = orgSubType;
	}

	public String getAuthDomain() {
		return authDomain;
	}

	public void setAuthDomain(String authDomain) {
		this.authDomain = authDomain;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getRealmCode() {
		return realmCode;
	}

	public void setRealmCode(String realmCode) {
		this.realmCode = realmCode;
	}

	public String getExternalOrgCode() {
		return externalOrgCode;
	}

	public void setExternalOrgCode(String externalOrgCode) {
		this.externalOrgCode = externalOrgCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGblCovOrgId() {
		return gblCovOrgId;
	}

	public void setGblCovOrgId(String gblCovOrgId) {
		this.gblCovOrgId = gblCovOrgId;
	}

	public String getPwdPolicyId() {
		return pwdPolicyId;
	}

	public void setPwdPolicyId(String pwdPolicyId) {
		this.pwdPolicyId = pwdPolicyId;
	}

	public String getAuthnPolicyId() {
		return authnPolicyId;
	}

	public void setAuthnPolicyId(String authnPolicyId) {
		this.authnPolicyId = authnPolicyId;
	}

	public String getIsReqReasonSaoReqd() {
		return isReqReasonSaoReqd;
	}

	public void setIsReqReasonSaoReqd(String isReqReasonSaoReqd) {
		this.isReqReasonSaoReqd = isReqReasonSaoReqd;
	}

	public String getIsReqReasonSaoDesc() {
		return isReqReasonSaoDesc;
	}

	public void setIsReqReasonSaoDesc(String isReqReasonSaoDesc) {
		this.isReqReasonSaoDesc = isReqReasonSaoDesc;
	}

	public Long getTopOrgId() {
		return topOrgId;
	}

	public Long getLastUpdUserId() {
		return lastUpdUserId;
	}

	public Long getCreatorId() {
		return creatorId;
	}
	
	
 
}
