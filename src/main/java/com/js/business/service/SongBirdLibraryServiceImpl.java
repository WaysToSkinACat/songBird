package com.js.business.service;

import javax.inject.Inject;

import com.js.persistence.repository.SongBirdLibraryRepository;
import com.js.util.JSONUtil;

public class SongBirdLibraryServiceImpl {

	@Inject 
	private SongBirdLibraryRepository songBird;
	
	@Inject	
	private JSONUtil util;
	
	
	public String getAllAccounts() {
		
		return songBird.getAllSongs();
	}

	public String createAccount(String account) {

		return songBird.createASong(account);
	}

	public String getAnAccount(Long songId) {

		return songBird.getASong(songId);
	}

	public String deleteAccount(Long songId) {
		
		return songBird.deleteASong(songId);
	}

	public String updateAccount(Long songId, String account) {
		return songBird.updateASong(songId, account);
	}

}

