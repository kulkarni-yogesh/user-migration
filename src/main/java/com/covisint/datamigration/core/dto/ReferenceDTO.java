package com.covisint.datamigration.core.dto;

public class ReferenceDTO {

	String id;
	String type;
	String realm;
	
	public ReferenceDTO(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}
	
	
}
