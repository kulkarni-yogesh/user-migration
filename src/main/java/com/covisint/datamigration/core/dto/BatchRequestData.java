package com.covisint.datamigration.core.dto;

import java.util.List;

public class BatchRequestData <T> {

	String type;
	private List<T> data;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
