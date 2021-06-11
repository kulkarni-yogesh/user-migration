package com.covisint.datamigration.core.dto;

import java.util.List;

public class Address {
	String type;
	List<String> streets;
	String city;
	String state;
	String postal;
	String country;

	public Address() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getStreets() {
		return streets;
	}

	public void setStreets(List<String> streets) {
		this.streets = streets;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
