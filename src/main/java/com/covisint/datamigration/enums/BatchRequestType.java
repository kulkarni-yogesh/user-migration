package com.covisint.datamigration.enums;

public enum BatchRequestType {
	
	ORGANIZATION_CREATE("ORGANIZATION_CREATE"),
	PERSON_CREATE("PERSON_CREATE");
	
	private String type;
	
	BatchRequestType(String type){
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
