package com.jbk.enums;

public enum UserRole {

	ADMIN("Admin"),
	COLLEGE("College"),
	COMPANY("Company");
	
	private final String value;
	
	private UserRole(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
