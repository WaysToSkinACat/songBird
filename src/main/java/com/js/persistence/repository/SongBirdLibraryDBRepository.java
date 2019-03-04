package com.js.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.js.persistence.domain.SongBirdAccount;
import com.js.persistence.domain.SongBirdLibrary;
import com.js.util.JSONUtil;


@Default
@Transactional(SUPPORTS)
public class SongBirdLibraryDBRepository implements SongBirdLibraryRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;	

	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllSongs() {
	Query query = manager.createQuery("SELECT a FROM SongBirdLibrary a");
	return util.getJSONForObject((Collection<SongBirdLibrary>) query.getResultList());

	}

	@Override
	@Transactional(REQUIRED)
		public String createASong(String song) {
		SongBirdAccount anAccount = util.getObjectForJSON(song, SongBirdAccount.class);
		manager.persist(anAccount);
		return "{\"message\": \"Song has been sucessfully added\"}";
	}
	
		
	@Override
	public String getASong(Long songId) {
		return util.getJSONForObject(manager.find(SongBirdAccount.class, songId));
		}

	@Override
	@Transactional(REQUIRED)
	public String deleteASong(Long songId) {
		if (manager.contains(manager.find(SongBirdAccount.class, songId))) {
			manager.remove(manager.find(SongBirdAccount.class, songId));
			return "{\"message\": \"account has been sucessfully deleted\"}";
		}
		return "{\"message\": \"no such account\"}";
	}
	

	@Override
	@Transactional(REQUIRED)
	public String updateASong(Long songId, String song) {
		if (manager.contains(manager.find(SongBirdAccount.class, songId))) {
			return "{\"message\": \"account has been sucessfully deleted\"}";
		}		
		return "{\"message\": \"no such account\"}";
	}
	

}







