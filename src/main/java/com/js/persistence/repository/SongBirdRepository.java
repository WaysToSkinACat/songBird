package com.js.persistence.repository;

import javax.persistence.EntityManager;

import com.js.util.JSONUtil;

public interface SongBirdRepository {

	String getAllAccounts();
	
	String createAccount(String account);
	
	String getAnAccount(String userName);
	
	String deleteAccount(String userName);

	String updateAccount(String userName, String account);
	
	void setUtil(JSONUtil util);

	void setManager(EntityManager manager);	
}
