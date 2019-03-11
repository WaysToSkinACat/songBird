package qa.com.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import qa.com.persistence.domain.Account;
import qa.com.util.JSONUtil;

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
		Query query = em.createQuery("SELECT a FROM Account a");
		return util.getJSONForObject((Collection<Account>) query.getResultList());
	}
	
	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		em.persist(anAccount);
		return "{\"message\": \"Account has been sucessfully added\"}";
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
			return "{\"message\": \"Account has been sucessfully deleted\"}";
		}
		return "{\"message\": \"no such Account\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateAccount(String userName, String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		if (em.contains(em.find(Account.class, userName))) {
			if (anAccount.getUserName() != null) {
				em.find(Account.class, userName).setUserName(anAccount.getUserName());
			}
			if (anAccount.getFirstName() != null) {
				em.find(Account.class, userName).setFirstName(anAccount.getFirstName());
			}
			if (anAccount.getLastName() != null) {
				em.find(Account.class, userName).setLastName(anAccount.getLastName());
			}
			if (anAccount.getEmail() != null) {
				em.find(Account.class, userName).setEmail(anAccount.getEmail());
			}
			
			return "{\"message\": \"Account has been sucessfully Updated\"}";
		}		
		return "{\"message\": \"no such Account\"}";
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
