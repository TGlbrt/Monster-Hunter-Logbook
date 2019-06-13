package rest;

import javax.ws.rs.Path;

import java.net.URI;
import java.util.List;

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

import logger.Log;
import logger.LoggerRepository;

@Path("/")
public class LoggerEndpoints {
	// global abstracts which will have a concretion passed during runtime
	@Inject
	private LoggerRepository loggerRepo;

	@GET
	@Path("/log/all")//get all
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllUser(@QueryParam(value=("name")) String userName){
		List<Log> UserData = loggerRepo.getAllUserLogs(userName);
		return Response.ok(UserData).build();
	}
	
	@GET
	@Path("/log/{id}")//get a log
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAUserLog(@QueryParam(value="id") int id){
		Log returnedLog = loggerRepo.getLog(id);
		return Response.ok(returnedLog).build();
	}

	@PUT
	@Path("/log/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Response updateLog(Log log,@QueryParam(value = "id") int id){
		Log returnedLog = loggerRepo.changeTime(id, log);
		return Response.ok(returnedLog).build();
	}

	@POST
	@Path("/log/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Response createLog(Log log){
		Log createdLog = loggerRepo.createLog(log);
	}
	
}
