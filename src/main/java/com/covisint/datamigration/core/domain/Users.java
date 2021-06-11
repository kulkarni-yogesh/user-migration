package com.covisint.datamigration.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USERS")
public class Users {
	
	@Id
	@Column(name = "USER_ID")
	private Integer id;
	
	@Column(name = "BELONGS_TO_ORGANIZATION_ID")
	private Integer orgId;
	
	@Column(name = "PREFERRED_LANGUAGE")
	private Integer language;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "MOBILE_PHONE")
	private String mobilePhone;
	
	@Column(name = "FAX")
	private String fax;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SSO_USER_ID")
	private String ssoUserId;
	
	@Column(name="PREF_CURRENCY")
	private String currency;
	
	@Column(name="TIME_ZONE_ID")
	private Integer timeZoneId;
	
	@Column(name = "CHALLENGE_ANSWER")
	private String challengeAnswer;
	
	@Column(name = "CHALLENGE_QUESTION")
	private String challengeQuestion;
	
	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	
	@Column(name = "ADDRESS1")
	private String address1;
	
	@Column(name = "ADDRESS2")
	private String address2;
	
	@Column(name = "ADDRESS3")
	private String address3;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE_PROVINCE")
	private String stateProvince;
	
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	
	@Column(name = "STATUS_ENUM")
	private Integer statusEnum;
	
	@Column(name = "LAST_STATUS_ID")
	private Integer lastStatusId;
	
	@Column(name = "LAST_UPD_SSO_ID")
	private String lastUpdSsoId;
	
	@Column(name = "LAST_UPD_DT")
	private Date lastUpdDt;
	
	@Column(name = "LAST_UPD_USER_ID")
	private Integer lastUpdUserId;
	
	@Column(name = "LAST_LOGIN_DT")
	private Date lastLoginDt;
	
	@Column(name = "SMS_ADDRESS")
	private String smsAddress;
	
	@Column(name = "USER_TYPE")
	private String userType;
	
	@Column(name = "LAST_ANTI_BOT")
	private String lastAntiBot;
	
	@Column(name = "ACTIVATION_DT")
	private Date activationDt;
	
	@Column(name = "FIXED_QUESTION_1_ID")
	private Integer fixedQuestion1Id;
	
	@Column(name = "FIXED_QUESTION_1_ANSWER")
	private String fixedQuestion1Answer;
	
	@Column(name = "FIXED_QUESTION_2_ID")
	private Integer fixedQuestion2Id;
	
	@Column(name = "FIXED_QUESTION_2_ANSWER")
	private String fixedQuestion2Answer;
	
	@Column(name = "PIN")
	private String pin;
	
	@Column(name = "SUFFIX_NAME")
	private String suffixName;
	
	@Column(name = "AUTH_DOMAIN")
	private String authDomain;
	
	@Column(name = "IDP_USER_ID")
	private String idpUserId;
	
	@Column(name = "REALM_CODE")
	private String realmCode;
	
	@Column(name = "GBL_COV_USER_ID")
	private String gblCovUserId;
	
	@Column(name = "LAST_LOGOUT_DT")
	private Date lastLogoutDt;
	
	@Column(name = "EXTERNAL_GUID")
	private String externalGuid;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsoUserId() {
		return ssoUserId;
	}

	public void setSsoUserId(String ssoUserId) {
		this.ssoUserId = ssoUserId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(Integer timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public String getChallengeAnswer() {
		return challengeAnswer;
	}

	public void setChallengeAnswer(String challengeAnswer) {
		this.challengeAnswer = challengeAnswer;
	}

	public String getChallengeQuestion() {
		return challengeQuestion;
	}

	public void setChallengeQuestion(String challengeQuestion) {
		this.challengeQuestion = challengeQuestion;
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

	public Date getLastUpdDt() {
		return lastUpdDt;
	}

	public void setLastUpdDt(Date lastUpdDt) {
		this.lastUpdDt = lastUpdDt;
	}

	public Integer getLastUpdUserId() {
		return lastUpdUserId;
	}

	public void setLastUpdUserId(Integer lastUpdUserId) {
		this.lastUpdUserId = lastUpdUserId;
	}

	public Date getLastLoginDt() {
		return lastLoginDt;
	}

	public void setLastLoginDt(Date lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}

	public String getSmsAddress() {
		return smsAddress;
	}

	public void setSmsAddress(String smsAddress) {
		this.smsAddress = smsAddress;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLastAntiBot() {
		return lastAntiBot;
	}

	public void setLastAntiBot(String lastAntiBot) {
		this.lastAntiBot = lastAntiBot;
	}

	public Date getActivationDt() {
		return activationDt;
	}

	public void setActivationDt(Date activationDt) {
		this.activationDt = activationDt;
	}

	public Integer getFixedQuestion1Id() {
		return fixedQuestion1Id;
	}

	public void setFixedQuestion1Id(Integer fixedQuestion1Id) {
		this.fixedQuestion1Id = fixedQuestion1Id;
	}

	public String getFixedQuestion1Answer() {
		return fixedQuestion1Answer;
	}

	public void setFixedQuestion1Answer(String fixedQuestion1Answer) {
		this.fixedQuestion1Answer = fixedQuestion1Answer;
	}

	public Integer getFixedQuestion2Id() {
		return fixedQuestion2Id;
	}

	public void setFixedQuestion2Id(Integer fixedQuestion2Id) {
		this.fixedQuestion2Id = fixedQuestion2Id;
	}

	public String getFixedQuestion2Answer() {
		return fixedQuestion2Answer;
	}

	public void setFixedQuestion2Answer(String fixedQuestion2Answer) {
		this.fixedQuestion2Answer = fixedQuestion2Answer;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getSuffixName() {
		return suffixName;
	}

	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}

	public String getAuthDomain() {
		return authDomain;
	}

	public void setAuthDomain(String authDomain) {
		this.authDomain = authDomain;
	}

	public String getIdpUserId() {
		return idpUserId;
	}

	public void setIdpUserId(String idpUserId) {
		this.idpUserId = idpUserId;
	}

	public String getRealmCode() {
		return realmCode;
	}

	public void setRealmCode(String realmCode) {
		this.realmCode = realmCode;
	}

	public String getGblCovUserId() {
		return gblCovUserId;
	}

	public void setGblCovUserId(String gblCovUserId) {
		this.gblCovUserId = gblCovUserId;
	}

	public Date getLastLogoutDt() {
		return lastLogoutDt;
	}

	public void setLastLogoutDt(Date lastLogoutDt) {
		this.lastLogoutDt = lastLogoutDt;
	}

	public String getExternalGuid() {
		return externalGuid;
	}

	public void setExternalGuid(String externalGuid) {
		this.externalGuid = externalGuid;
	}
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", orgId=" + orgId + ", language=" + language + ", title="
				+ title + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", jobTitle=" + jobTitle + ", phone=" + phone
				+ ", mobilePhone=" + mobilePhone + ", fax=" + fax + ", email=" + email
				+ ", ssoUserId=" + ssoUserId +", currency="+ currency + ", timeZoneId="+ timeZoneId + ", challengeAnswer="+ challengeAnswer +
				", challengeQuestion="+ challengeQuestion + ", address1="+ address1 + ", address2="+ address2 +
				 ", address3="+ address3 + ", city="+ city + ", stateProvince="+ stateProvince +
				  ", postalCode="+ postalCode + ", statusEnum="+ statusEnum + ", lastStatusId="+ lastStatusId +
				   ", lastUpdSsoId="+ lastUpdSsoId + ", lastUpdDt="+ lastUpdDt +
				    ", lastUpdUserId="+ lastUpdUserId + ", lastLoginDt="+ lastLoginDt + ", smsAddress="+ smsAddress +
				    ", userType="+ userType + ", lastAntiBot="+ lastAntiBot + ", activationDt="+ activationDt +
				    ", fixedQuestion1Id="+ fixedQuestion1Id + ", fixedQuestion1Answer="+ fixedQuestion1Answer + ", fixedQuestion2Id="+ fixedQuestion2Answer +
				    ", pin="+ pin + ", suffixName="+ suffixName + ", authDomain="+ authDomain + ", idpUserId="+ idpUserId +
				    ", realmCode="+ realmCode + ", gblCovUserId="+ gblCovUserId + ", lastLogoutDt="+ lastLogoutDt +
				    ", externalGuid="+ externalGuid +"]";
	}

}
