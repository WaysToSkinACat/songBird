package qa.com.business.service;

import javax.inject.Inject;

import qa.com.persistence.repository.SongBirdRepository;
import qa.com.util.JSONUtil;


public class SongBirdServiceImpl implements SongBirdService {

	@Inject 
	private SongBirdRepository songBird;
	
	@Inject	
	private JSONUtil util;
	
	@Override
	public String getAllAccounts() {
		
		return songBird.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {

		return songBird.createAccount(account);
	}

	@Override
	public String getAnAccount(String userName) {

		return songBird.getAnAccount(userName);
	}

	@Override
	public String deleteAccount(String userName) {
		
		return songBird.deleteAccount(userName);
	}

	@Override
	public String updateAccount(String userName, String account) {
		return songBird.updateAccount(userName, account);
	}

	@Override
	public void setRepository(SongBirdRepository songBird) {
		this.songBird = songBird;
		
	}

}
