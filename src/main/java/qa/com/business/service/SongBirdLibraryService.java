package qa.com.business.service;

import qa.com.persistence.repository.SongBirdLibraryRepository;

public interface SongBirdLibraryService {
	
	String getAllSongs();
	
	String createASong(String song);
	
	String getASong(Long songId);
	
	String deleteASong(Long songId);

	String updateASong(Long songId, String song);
	
	void setRepository(SongBirdLibraryRepository repo);
	
}
