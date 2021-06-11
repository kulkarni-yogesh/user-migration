package com.covisint.datamigration.core.dto;

public class NameDTO {
	
	private String prefix;
	
	private String given;
	
	private String middle;
	
	private String surname;
	
	private String suffix;
	
	
	public String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getGiven() {
		return given;
	}
	
	public void setGiven(String given) {
		this.given = given;
	}
	
	public String getMiddle() {
		return middle;
	}
	
	public void setMiddle(String middle) {
		this.middle = middle;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getSuffix() {
		return suffix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
}
