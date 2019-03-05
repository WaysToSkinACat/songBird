package com.js.persistence.repository;

import javax.persistence.EntityManager;

import com.js.util.JSONUtil;

public interface SongBirdLibraryRepository {
	
	String getAllSongs();
	
	String createASong(String song);
	
	String getASong(Long songId);
	
	String deleteASong(Long songId);

	String updateASong(Long songId, String song);
	
	void setUtil(JSONUtil util);

	void setManager(EntityManager manager);
}
