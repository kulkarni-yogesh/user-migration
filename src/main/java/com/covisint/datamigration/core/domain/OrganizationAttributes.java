package com.covisint.datamigration.core.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORG_ATTRIBUTES")
public class OrganizationAttributes {
	
	@Id
	@Column(name = "ORGANIZATION_ID")
	private Long orgId;
	
	@Column(name = "ATTRIBUTE_ID")
	private Long attrId;
	
	@Column(name = "ATTRIBUTE_VALUE")
	private String attrValue;
	
	@Column(name = "PACKAGE_ID")
	private Long pkgId;
	
	@Column(name = "LAST_UPD_DT")
	private Date lastUpDate;
	
	@Column(name = "LAST_UPD_USER_ID")
	private Long lastUpUserId;

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public Long getPkgId() {
		return pkgId;
	}

	public void setPkgId(Long pkgId) {
		this.pkgId = pkgId;
	}

	public Date getLastUpDate() {
		return lastUpDate;
	}

	public void setLastUpDate(Date lastUpDate) {
		this.lastUpDate = lastUpDate;
	}

	public Long getLastUpUserId() {
		return lastUpUserId;
	}

	public void setLastUpUserId(Long lastUpUserId) {
		this.lastUpUserId = lastUpUserId;
	}
	
	
	

}
