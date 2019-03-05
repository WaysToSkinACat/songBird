package com.js.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.js.business.service.SongBirdLibraryService;


@Path("/library")
public class SongBirdLibraryEndpoint {

	
	@Inject
	private SongBirdLibraryService services;
	
	@Path("/getAllSongs")
	@GET
	@Produces({ "application/json" })
	public String getAllSongs() {
		return services.getAllSongs();
	}

	@Path("/createASong")
	@POST
	@Produces({ "application/json" })
	public String createASong(String song) {
		return services.createASong(song);
	}

	@Path("/deleteASong/{userName}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteASong(@PathParam("userName") Long songId) {
		return services.deleteASong(songId);
	}

	@Path("/updateASong/{userName}")
	@PUT
	@Produces({ "application/json" })
	public String updateASong(@PathParam("userName") Long songId, String song) {
		return services.updateASong(songId, song);
	}
}
