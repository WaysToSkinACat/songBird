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

	public String getAnAccount(String userName) {

		return songBird.getASong(userName);
	}

	public String deleteAccount(String userName) {
		
		return songBird.deleteASong(userName);
	}

	public String updateAccount(String userName, String account) {
		return songBird.updateASong(userName, account);
	}

}

