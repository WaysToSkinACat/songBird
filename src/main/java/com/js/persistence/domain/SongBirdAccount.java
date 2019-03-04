package com.js.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SongBirdAccount {
	@Id
	@Column(name="userName", unique=true, columnDefinition = "VARCHAR(15)")
	private String userName;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	
	
	
	public SongBirdAccount() {
		
	}
	
	
	public SongBirdAccount(String userName, String firstName, String lastName) {

		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
}
