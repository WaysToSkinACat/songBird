package com.js.persistence.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;

import com.js.persistence.domain.Song;
import com.js.util.JSONUtil;


@Alternative
public class SongBirdLibraryMapRepository implements SongBirdLibraryRepository {

	Map<Long, Song> songMap = new HashMap<Long, Song>();

	public Map<Long, Song> getSongMap() {
		return songMap;
	}

	public void setSongMap(Map<Long, Song> songMap) {
		this.songMap = songMap;
	}

	private JSONUtil util = new JSONUtil();
	private EntityManager manager;

	public String getAllSongs() {
		return util.getJSONForObject(songMap.values());
	}

	public String createASong(String song) {
		Song aSong = util.getObjectForJSON(song, Song.class);
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
		Song aSong = util.getObjectForJSON(song, Song.class);
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

	@Override
	public void setUtil(JSONUtil util) {
		this.util = util;
		
	}

	@Override
	public void setManager(EntityManager manager) {
		this.manager = manager;
		
	}



}
