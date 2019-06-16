package rest;

import java.util.List;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import logger.User;
import logger.UserRepository;

@Path("/")
public class UserEndpoints {
	@Inject private UserRepository userRepo;
	
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam(value="id") int userId) {
		User user = userRepo.getUser(userId);
		return Response.ok(user).build();
	}

	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByName(@QueryParam(value="name") String userName){
		User user = userRepo.getUser(userName);
		return Response.ok(user).build();
	}
	
	@GET
	@Path("/user/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers(){
		List<User> users = userRepo.getAllUsers();
		return Response.ok(users).build();
	}

	@POST
	@Path("/user/")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({"application/json"})
	public Response createUser(User userJS, @Context UriInfo uriInfo) {
		User createdUser = userRepo.createUser(userJS);
		System.out.println(createdUser.getId());
		URI createdURI = uriInfo.getBaseUriBuilder().path("user/"+createdUser.getId()).build();
		System.out.println(createdURI);
		return Response.ok(createdURI.toString()).status(Status.CREATED).build();
	}

	@DELETE
	@Path("/user")
	@Consumes({"application/json"})
	public Response deleteUser(@QueryParam(value="name") String userName ,@Context UriInfo uriInfo){
		//MultivaluedMap<String,String> paramMap = uriInfo.getPathParameters();
		//System.out.println("delete : " + paramMap.get("name").toString());
		//userRepo.deleteUsers();
		//userRepo.deleteUser(1);
		userRepo.deleteUser(userName);//paramMap.get("name").toString()).getId());
		return Response.noContent().build();
	}

	@PUT
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({"application/json"})
	public Response updateUser(@QueryParam(value="name") String userName, User upUser){
		//MultivaluedMap<String,String> paramMap = uriInfo.getPathParameters();
		//System.out.println("updateUser : " + paramMap.get("name").toString() + " | " + paramMap.get("upname").toString());
		User user = userRepo.updateUser(upUser,userRepo.getUser(userName).getId());
		return Response.ok(user).status(Status.CREATED).build();
	}
	
}
