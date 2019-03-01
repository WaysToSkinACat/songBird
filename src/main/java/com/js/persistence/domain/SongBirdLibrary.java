package com.js.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SongBirdLibrary {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(length = 15)
	private Long songID;
	@Column(length = 50)
	private String songName;
	@Column(length = 3)
	private int bPM;
	@Column(length = 255)
	private String description;
	
	private String userName;

	public SongBirdLibrary(Long songID, String songName, int bPM, String description) {

		this.songID = songID;
		this.songName = songName;
		this.bPM = bPM;
		this.description = description;
	}

	public SongBirdLibrary() {

	}

	public SongBirdLibrary(Long songID, String songName, int bPM, String description, List<SongBirdAccount> trainees,
			List<SongBirdAccount> account) {
		super();
		this.songID = songID;
		this.songName = songName;
		this.bPM = bPM;
		this.description = description;

	}

	public Long getSongID() {
		return songID;
	}

	public void setSongID(Long songID) {
		this.songID = songID;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public int getbPM() {
		return bPM;
	}

	public void setbPM(int bPM) {
		this.bPM = bPM;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
