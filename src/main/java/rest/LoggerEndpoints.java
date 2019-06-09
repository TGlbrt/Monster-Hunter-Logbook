package rest;
import javax.ws.rs.Path;

import java.net.URI;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/*import com.qa.repository.Account;
import com.qa.repository.AccountRepository;
import com.qa.repository.Relation;*/

@Path("/")
public class LoggerEndpoints {
	//global abstracts which will have a concretion passed during runtime
	@Ingect private Table table;

	@inject private LoggerRepostory loggerRepo;

	@GET
	@Path("/user/")//get all
	@Produces(MediaType.TEXT_PLAIN)
	public response getAllUser(){
		List<Log> UserData = loggerRepo.getAll();
		return Response.ok(UserData);
	}
	
	@GET
	@Path("/user/{logName}")//get a log
	@Produces(MediaType.JSON)
	public Response getAUserLog(PathParam "logName" reqLog){
		Log returnedLog = loggerRepo.getLogByName(reqLog);
		return Response.ok(returnedLog);
	}

	/*
	 * @POST
	 * 
	 * @Path("/account")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 * 
	 * @Consumes({"application/json"}) public Response createAccount(Account
	 * account, @Context UriInfo uriInfo) {
	 * System.out.println("mooooooooooooooooooooOOOOOOOOOOOOOOOOOOOOOOO"); Account
	 * returnValue = accountRepo.createAccount(account);
	 * System.out.println(returnValue.getId());
	 * System.out.println(returnValue.getAccountName()); URI uri =
	 * uriInfo.getBaseUriBuilder().path("" +
	 * String.valueOf(returnValue.getId())).build(); return
	 * Response.created(uri).build(); }
	 */
		
		
	/*	@PUT
		@Path("new")
		@Consumes("account/{text}")
		public Response putText(@PathParam(value = "text") String text) {
			gText = text;
			return getText();
		}*/
}
