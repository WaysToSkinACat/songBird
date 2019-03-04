package com.js.persistence.repository;

public interface SongBirdLibraryRepository {
	
	String getAllSongs();
	
	String createASong(String song);
	
	String getASong(Long songId);
	
	String deleteASong(Long songId);

	String updateASong(Long songId, String song);
}
