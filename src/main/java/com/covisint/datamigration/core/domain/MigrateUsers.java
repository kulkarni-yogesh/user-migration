package com.covisint.datamigration.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MIGRATE_USERS_DEV")
public class MigrateUsers {
	
	@Id
	@Column(name = "LEGACY_USER_ID")
	private String legacyUserId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "NEXTGEN_USER_ID")
	private String nextgenUserId;
	
	@Column(name = "LEGACY_BELONGS_TO_ORG_ID")
	private String legacyBelongsToOrgId;
	
	@Column(name = "NEXTGEN_BELONGS_TO_ORG_ID")
	private String nextgenBelongsToOrgId;

	
	public String getLegacyUserId() {
		return legacyUserId;
	}

	public void setLegacyUserId(String legacyUserId) {
		this.legacyUserId = legacyUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNextgenUserId() {
		return nextgenUserId;
	}

	public void setNextgenUserId(String nextgenUserId) {
		this.nextgenUserId = nextgenUserId;
	}

	public String getLegacyBelongsToOrgId() {
		return legacyBelongsToOrgId;
	}

	public void setLegacyBelongsToOrgId(String legacyBelongsToOrgId) {
		this.legacyBelongsToOrgId = legacyBelongsToOrgId;
	}

	public String getNextgenBelongsToOrgId() {
		return nextgenBelongsToOrgId;
	}

	public void setNextgenBelongsToOrgId(String nextgenBelongsToOrgId) {
		this.nextgenBelongsToOrgId = nextgenBelongsToOrgId;
	}
	
}
