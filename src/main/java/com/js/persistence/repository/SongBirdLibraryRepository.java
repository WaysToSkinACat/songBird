package com.js.persistence.repository;

public interface SongBirdLibraryRepository {
	
	String getAllSongs();
	
	String createASong(String song);
	
	String getASong(String songId);
	
	String deleteASong(String songId);

	String updateASong(String songId, String song);
}
