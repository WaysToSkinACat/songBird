package qa.com.persistence.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;

import qa.com.persistence.domain.Account;
import qa.com.util.JSONUtil;


@Alternative
public class SongBirdMapRepository implements SongBirdRepository {

	Map<String, Account> accountMap = new HashMap<String, Account>();

	public Map<String, Account> getAccountMap() {
		return accountMap;
	}

	public void setAccountMap(Map<String, Account> accountMap) {
		this.accountMap = accountMap;
	}

	private JSONUtil util = new JSONUtil();
	private EntityManager em;

	public String getAllAccounts() {
		return util.getJSONForObject(accountMap.values());
	}

	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
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
		Account anAccount = util.getObjectForJSON(account, Account.class);
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
