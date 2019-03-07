package qa.com.business.service;

import qa.com.persistence.repository.SongBirdLibraryRepository;

public interface SongBirdLibraryService {
	
	String getAllSongs();
	
	String createASong(String song);
	
	String getASong(Long userName);
	
	String deleteASong(Long userName);

	String updateASong(Long userName, String song);
	
	void setRepository(SongBirdLibraryRepository repo);
	
}
