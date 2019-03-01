package com.js.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.js.business.service.SongBirdService;

@Path("/library")
public class SongBirdLibraryEndpoint {

	
	@Inject
	private SongBirdService service;
	
	@Path("/getASong")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	@Path("/createASong")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String song) {
		return service.createAccount(song);
	}

	@Path("/deleteASong/{userName}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("userName") String songId) {
		return service.deleteAccount(songId);
	}

	@Path("/updateASong/{userName}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("userName") String songId, String song) {
		return service.updateAccount(songId, song);
	}
}
