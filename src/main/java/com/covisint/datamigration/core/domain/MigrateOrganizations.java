package com.covisint.datamigration.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MIGRATE_ORGANIZATIONS_DEV")
public class MigrateOrganizations {
	
	@Id
	@Column(name = "LEGACY_ORG_ID")
	private Long legacyOgId;
	
	@Column(name = "GBL_COV_ORG_ID")
	private String gblCovOrgId;
	
	@Column(name = "ORG_NAME")
	private String orgName;
	
	@Column(name = "JOB_ID")
	private String jobId;
	
	@Column(name = "MIGRATE_STATUS")
	private String migrateStatus;
	
	@Column(name = "ERRORS")
	private String errors;
	
	public Long getLegacyOgId() {
		return legacyOgId;
	}

	public void setLegacyOgId(Long legacyOgId) {
		this.legacyOgId = legacyOgId;
	}

	public String getGblCovOrgId() {
		return gblCovOrgId;
	}

	public void setGblCovOrgId(String gblCovOrgId) {
		this.gblCovOrgId = gblCovOrgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getMigrateStatus() {
		return migrateStatus;
	}

	public void setMigrateStatus(String migrateStatus) {
		this.migrateStatus = migrateStatus;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}
}
