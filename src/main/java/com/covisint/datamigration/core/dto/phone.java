package com.covisint.datamigration.core.dto;

import com.covisint.datamigration.enums.PhoneType;

public class phone {
	PhoneType type;
	String number;
	
	public phone() {
		
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
