package qa.com.persistence.repository;

import javax.persistence.EntityManager;

import qa.com.util.JSONUtil;

public interface SongBirdLibraryRepository {
	
	String getAllSongs();
	
	String createASong(String song);
	
	String getASong(Long songId);
	
	String deleteASong(Long songId);

	String updateASong(Long songId, String song);
	
	void setUtil(JSONUtil util);

	void setManager(EntityManager manager);
}
