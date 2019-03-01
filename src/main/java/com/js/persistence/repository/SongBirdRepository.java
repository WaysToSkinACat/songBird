package com.js.persistence.repository;

public interface SongBirdRepository {

	String getAllAccounts();
	
	String createAccount(String account);
	
	String getAnAccount(String userName);
	
	String deleteAccount(String userName);

	String updateAccount(String userName, String account);
}
