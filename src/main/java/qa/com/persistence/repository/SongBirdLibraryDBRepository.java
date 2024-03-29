package qa.com.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import qa.com.persistence.domain.Account;
import qa.com.persistence.domain.Song;
import qa.com.util.JSONUtil;


@Default
@Transactional(SUPPORTS)
public class SongBirdLibraryDBRepository implements SongBirdLibraryRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;	

	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllSongs() {
	Query query = manager.createQuery("SELECT a FROM Song a");
	return util.getJSONForObject((Collection<Song>) query.getResultList());

	}

	@Override
	@Transactional(REQUIRED)
		public String createASong(String song) {
		Song aSong = util.getObjectForJSON(song, Song.class);
		manager.persist(aSong);
		return "{\"message\": \"Song has been sucessfully added\"}";
	}
	
		
	@Override
	public String getASong(Long songId) {
		return util.getJSONForObject(manager.find(Song.class, songId));
		}

	@Override
	@Transactional(REQUIRED)
	public String deleteASong(Long songId) {
		if (manager.contains(manager.find(Song.class, songId))) {
			manager.remove(manager.find(Song.class, songId));
			return "{\"message\": \"account has been sucessfully deleted\"}";
		}
		return "{\"message\": \"no such account\"}";
	}
	

	@Override
	@Transactional(REQUIRED)
	public String updateASong(Long songId, String song) {
		Song aSong = util.getObjectForJSON(song, Song.class);
		if (manager.contains(manager.find(Song.class, songId))) {
			if (aSong.getbPM() != null) {
				manager.find(Song.class, songId).setbPM(aSong.getbPM());
			}
			if (aSong.getDescription() != null) {
				manager.find(Song.class, songId).setDescription(aSong.getDescription());
			}
			if (aSong.getSongName() != null) {
				manager.find(Song.class, songId).setSongName(aSong.getSongName());
			}
//			if (aSong.getUserName() != null) {
//				manager.find(Song.class, songId).setUserName(aSong.getUserName());
//			}
			return "{\"message\": \"account has been sucessfully Updated\"}";
		}		
		return "{\"message\": \"no such account\"}";
	}

	@Override
	public void setUtil(JSONUtil util) {
		this.util = util;
		
	}

	@Override
	public void setManager(EntityManager manager) {
		this.manager = manager;
		
	}
	

}







