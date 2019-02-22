package com.js.business.service;

import javax.inject.Inject;

import com.js.persistence.repository.SongBirdAccountRepository;
import com.js.util.JSONUtil;


public class SongBirdServiceImpl implements SongBirdService {

	@Inject 
	private SongBirdAccountRepository songBird;
	
	@Inject	
	private JSONUtil util;
	
	
	public String getAllAccounts() {
		
		return songBird.getAllAccounts();
	}

	public String createAccount(String account) {

		return songBird.createAccount(account);
	}

	public String getAnAccount(String userName) {

		return songBird.getAnAccount(userName);
	}

	public String deleteAccount(String userName) {
		
		return songBird.deleteAccount(userName);
	}

	public String updateAccount(String userName, String account) {
		return songBird.updateAccount(userName, account);
	}

}
