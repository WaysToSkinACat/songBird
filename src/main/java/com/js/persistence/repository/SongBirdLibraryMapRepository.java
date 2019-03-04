package com.js.persistence.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;

import com.js.persistence.domain.SongBirdLibrary;
import com.js.util.JSONUtil;


@Alternative
public class SongBirdLibraryMapRepository implements SongBirdLibraryRepository {

	Map<Long, SongBirdLibrary> songMap = new HashMap<Long, SongBirdLibrary>();

	public Map<Long, SongBirdLibrary> getSongMap() {
		return songMap;
	}

	public void setSongMap(Map<Long, SongBirdLibrary> songMap) {
		this.songMap = songMap;
	}

	private JSONUtil util = new JSONUtil();

	public String getAllSongs() {
		return util.getJSONForObject(songMap.values());
	}

	public String createASong(String song) {
		SongBirdLibrary aSong = util.getObjectForJSON(song, SongBirdLibrary.class);
		songMap.put(aSong.getSongId(), aSong);
		return "{\"message\": \"song has been sucessfully added\"}";
	}

	public String deleteASong(Long songId) {
		if (songMap.get(songId) != null) {
			songMap.remove(songId);
			return "{\"message\": \"song has been sucessfully deleted\"}";
		}
		return "{\"message\": \"no such song\"}";
	}

	public String updateASong(Long songId, String song) {
		SongBirdLibrary aSong = util.getObjectForJSON(song, SongBirdLibrary.class);
		if (songMap.get(songId) != null) {
			songMap.put(songId, aSong);
			return "{\"message\": \"song has been sucessfully updated\"}";
		}
		return "{\"message\": \"no such song\"}";
	}

	public int countByName(String name) {
		return songMap.values().stream().filter(n -> n.getSongName().equals(name)).collect(Collectors.toList()).size();
	}

	public String getNSongsAlphabetical(int num) {
		return null;
	}

	public String getASong(Long songId) {
		return null;
	}



}
