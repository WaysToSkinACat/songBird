package qa.com.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import qa.com.business.service.SongBirdService;


@Path("/account")
public class SongBirdEndpoint {
	
	@Inject
	private SongBirdService service;
	
	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) {
		return service.createAccount(account);
	}

	@Path("/deleteAccount/{userName}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("userName") String userName) {
		return service.deleteAccount(userName);
	}

	@Path("/updateAccount/{userName}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("userName") String userName, String account) {
		return service.updateAccount(userName, account);
	}


}
