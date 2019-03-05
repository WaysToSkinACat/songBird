package com.js.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SongBirdAccount {
	
	public SongBirdAccount() {
		
	}
	
	@OneToMany(mappedBy = "userName", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<SongBirdLibrary> songs = new ArrayList<SongBirdLibrary>();
	
	public SongBirdAccount(String userName, String firstName, String lastName) {

		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Id
	@Column(name="userName", unique=true, columnDefinition = "VARCHAR(15)")
	private String userName;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	
	

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

	public List<SongBirdLibrary> getSongs() {
		return songs;
	}

	public void setSongs(List<SongBirdLibrary> songs) {
		this.songs = songs;
	}

	
	
}
