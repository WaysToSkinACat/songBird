package com.js.business.service;

public interface SongBirdLibraryService {
	
	String getAllSongs();
	
	String createASong(String account);
	
	String getASong(String userName);
	
	String deleteASong(String userName);

	String updateASong(String userName, String account);
}
