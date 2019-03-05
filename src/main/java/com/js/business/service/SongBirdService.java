package com.js.business.service;

import com.js.persistence.repository.SongBirdRepository;

public interface SongBirdService {

	String getAllAccounts();
	
	String createAccount(String account);
	
	String getAnAccount(String userName);
	
	String deleteAccount(String userName);

	String updateAccount(String userName, String account);
	
	void setRepository(SongBirdRepository repo);
	
}
