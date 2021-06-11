package com.covisint.datamigration.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MIGRATE_ATTRIBUTES")
public class MigrateAttributes {
	
	@Id
	@Column(name = "LEGACY_ATTRIBUTE_ID")
	private Long legacyAttrId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "NEXTGEN_ATTRIBUTE_ID")
	private Long nextGenAttrId;

	public Long getLegacyAttrId() {
		return legacyAttrId;
	}

	public void setLegacyAttrId(Long legacyAttrId) {
		this.legacyAttrId = legacyAttrId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNextGenAttrId() {
		return nextGenAttrId;
	}

	public void setNextGenAttrId(Long nextGenAttrId) {
		this.nextGenAttrId = nextGenAttrId;
	}
	
	
	
}
