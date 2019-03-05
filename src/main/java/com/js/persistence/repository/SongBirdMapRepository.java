package com.js.persistence.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;

import com.js.persistence.domain.SongBirdAccount;
import com.js.util.JSONUtil;


@Alternative
public class SongBirdMapRepository implements SongBirdRepository {

	Map<String, SongBirdAccount> accountMap = new HashMap<String, SongBirdAccount>();

	public Map<String, SongBirdAccount> getAccountMap() {
		return accountMap;
	}

	public void setAccountMap(Map<String, SongBirdAccount> accountMap) {
		this.accountMap = accountMap;
	}

	private JSONUtil util = new JSONUtil();
	private EntityManager em;

	public String getAllAccounts() {
		return util.getJSONForObject(accountMap.values());
	}

	public String createAccount(String account) {
		SongBirdAccount anAccount = util.getObjectForJSON(account, SongBirdAccount.class);
		accountMap.put(anAccount.getuserName(), anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	public String deleteAccount(String userName) {
		if (accountMap.get(userName) != null) {
			accountMap.remove(userName);
			return "{\"message\": \"account has been sucessfully deleted\"}";
		}
		return "{\"message\": \"no such account\"}";
	}

	public String updateAccount(String userName, String account) {
		SongBirdAccount anAccount = util.getObjectForJSON(account, SongBirdAccount.class);
		if (accountMap.get(userName) != null) {
			accountMap.put(userName, anAccount);
			return "{\"message\": \"account has been sucessfully updated\"}";
		}
		return "{\"message\": \"no such account\"}";
	}

	public int countByName(String name) {
		return accountMap.values().stream().filter(n -> n.getFirstName().equals(name)).collect(Collectors.toList()).size();
	}

	public String getNAccountsAlphabetical(int num) {
		return null;
	}

	public String getAnAccount(String userName) {
		return null;
	}

	@Override
	public void setUtil(JSONUtil util) {
		this.util = util;
		
	}

	@Override
	public void setManager(EntityManager em) {
		this.em = em;
		
	}

}
