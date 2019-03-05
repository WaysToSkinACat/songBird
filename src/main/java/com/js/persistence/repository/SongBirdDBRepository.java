package com.js.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.js.persistence.domain.Account;
import com.js.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Default
@Transactional(SUPPORTS)
public class SongBirdDBRepository implements SongBirdRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;	
	
	@Inject
	private JSONUtil util;


	
	
	@Override
	public String getAllAccounts() {
		Query query = em.createQuery("SELECT a FROM SongBirdAccount a");
		return util.getJSONForObject((Collection<Account>) query.getResultList());
	}
	
	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		em.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	public String getAnAccount(String userName) {
		return util.getJSONForObject(em.find(Account.class, userName));
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(String userName) {
		if (em.contains(em.find(Account.class, userName))) {
			em.remove(em.find(Account.class, userName));
			return "{\"message\": \"account has been sucessfully deleted\"}";
		}
		return "{\"message\": \"no such account\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateAccount(String userName, String account) {
		if (em.contains(em.find(Account.class, userName))) {
			return "{\"message\": \"account has been sucessfully deleted\"}";
		}		
		return "{\"message\": \"no such account\"}";
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
