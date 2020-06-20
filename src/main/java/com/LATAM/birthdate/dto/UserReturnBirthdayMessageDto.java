package com.LATAM.birthdate.dto;

public class UserReturnBirthdayMessageDto {
	
	private String name;
	private String lastName;
	private String birthdate;
	private Integer age;
	private Integer daysToBirthdate;
	private PoemReturn birthdateMessage;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDaysToBirthdate() {
		return daysToBirthdate;
	}
	public void setDaysToBirthdate(Integer daysToBirthdate) {
		this.daysToBirthdate = daysToBirthdate;
	}
	public PoemReturn getBirthdateMessage() {
		return birthdateMessage;
	}
	public void setBirthdateMessage(PoemReturn birthdateMessage) {
		this.birthdateMessage = birthdateMessage;
	}
	
}
