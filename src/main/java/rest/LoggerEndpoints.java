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
	/*
	 * @Inject private Relation relation;
	 * 
	 * @Inject private AccountRepository accountRepo;
	 * 
	 * @GET
	 * 
	 * @Path("account")
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public Response getText() { //String text =
	 * "Hello World!"; String gText = relation.message(); return
	 * Response.ok(gText).build(); //return Response.accepted(gText).build();
	 * //return Response.noContent().build(); //return
	 * Response.serverError().build(); }
	 */
		
		/*@GET
		@Path("account/{id}")
		@Produces(MediaType.TEXT_PLAIN)
		public Response getAccountById(@PathParam(value = "id") int id) {
			Account returnValue = accountRepo.getAccount(id);
			
			return Response.ok("name : " + returnValue.getAccountName() + " your worth(peasant) : " + String.valueOf(returnValue.getAccountValue());
		}*/
		
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
