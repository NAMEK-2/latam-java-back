package com.LATAM.birthdate.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class UserEntryDto {
	
	private String name;
	private String lastName;
	private String birthdate;
	
	@NotNull
	@NotEmpty
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotNull
	@NotEmpty
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@NotNull
	@NotEmpty
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

}
