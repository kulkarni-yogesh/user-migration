package com.covisint.datamigration.enums;

public enum PhoneType {

	main("main"),
	mobile("mobile"),
	fax("fax");
	
	private String type;
	
	PhoneType(String type){
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
