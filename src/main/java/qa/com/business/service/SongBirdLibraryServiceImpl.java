package qa.com.business.service;

import javax.inject.Inject;

import qa.com.persistence.repository.SongBirdLibraryRepository;
import qa.com.util.JSONUtil;

public class SongBirdLibraryServiceImpl implements SongBirdLibraryService{

	@Inject 
	private SongBirdLibraryRepository songBird;
	
	@Inject	
	private JSONUtil util;
	
	@Override
	public String getAllSongs() {
		
		return songBird.getAllSongs();
	}
	
	@Override
	public String createASong(String song) {

		return songBird.createASong(song);
	}
	
	@Override
	public String getASong(Long songId) {

		return songBird.getASong(songId);
	}
	
	@Override
	public String deleteASong(Long songId) {
		
		return songBird.deleteASong(songId);
	}
	@Override
	public String updateASong(Long songId, String song) {
		return songBird.updateASong(songId, song);
	}

	@Override
	public void setRepository(SongBirdLibraryRepository songBird) {
		this.songBird = songBird;
		
	}

}

