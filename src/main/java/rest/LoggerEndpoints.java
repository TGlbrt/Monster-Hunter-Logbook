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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import logger.Log;
import logger.LoggerRepository;

@Path("/")
public class LoggerEndpoints {
	@Inject
	private LoggerRepository loggerRepo;

	@GET
	@Path("/log/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUserLogs(@QueryParam(value=("user")) String userName){
		List<Log> userData = loggerRepo.getAllUserLogs(userName);
		return Response.ok(userData).build();
	}

	@GET
	@Path("/log/all/monster")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsersMonsterLogs(@QueryParam(value=("user")) String userName, @QueryParam(value="monster") String monsterName){
		List<Log> monsterUserLogs = loggerRepo.getUserLogsByMonster(userName, monsterName);
		return Response.ok(monsterUserLogs).build();
	}
	
	@GET
	@Path("/log/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAUserLog(@PathParam(value="id") int id){
		Log returnedLog = loggerRepo.getLog(id);
		return Response.ok(returnedLog).build();
	}

	@PUT
	@Path("/log/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Response updateLog(Log log,@PathParam(value = "id") int id){
		Log returnedLog = loggerRepo.changeExistingLog(id, log);
		return Response.ok(returnedLog).build();
	}

	@POST
	@Path("/log/")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes("application/json")
	public Response createLog(Log log,@Context UriInfo uriInfo){
		Log createdLog = loggerRepo.createLog(log);
		URI createdURI = uriInfo.getBaseUriBuilder().path("log/"+createdLog.getId()).build();
		return Response.ok(createdURI.toString()).status(Status.CREATED).build();
	}
	
	@DELETE
	@Path("/log/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteLog(@PathParam(value = "id") int id){
		loggerRepo.removeLog(id);
		return Response.accepted().status(Status.NO_CONTENT).build();
	}

}
