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

import logger.MonsterRepository;
import logger.Monster;

@Path("/")
public class MonsterEndpoints{
    @Inject private MonsterRepository monsterRepo;

    @GET
	@Path("/monster/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMonster(@PathParam(value="id") int monsterId) {
		Monster monster = monsterRepo.getMonster(monsterId);
		return Response.ok(monster).build();
	}

	@GET
	@Path("/monster")
	@Produces(MediaType.APPLICATION_JSON)
    public Response getMonsterByName(@QueryParam(value="name") String monsterName){
		Monster monster = monsterRepo.getMonster(monsterName);
		return Response.ok(monster).build();
	}
	
	@GET
	@Path("/monster/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMonsters(){
		List<Monster> monsters = monsterRepo.getAllMonsters();
		return Response.ok(monsters).build();
	}

	@POST
	@Path("/monster/")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({"application/json"})
	public Response createUser(Monster monsterJS, @Context UriInfo uriInfo) {
		Monster createdMonsterEntry = monsterRepo.createMonsterEntry(monsterJS);
		System.out.println(createdMonsterEntry.getId());
		URI createdURI = uriInfo.getBaseUriBuilder().path("user/monster/"+createdMonsterEntry.getId()).build();
		System.out.println(createdURI);
		return Response.ok(createdURI.toString()).status(Status.CREATED).build();
	}

	@DELETE
	@Path("/monster")
	@Consumes({"application/json"})
	public Response deleteUser(@QueryParam(value="name") String monsterName ,@Context UriInfo uriInfo){
		//MultivaluedMap<String,String> paramMap = uriInfo.getPathParameters();
		//System.out.println("delete : " + paramMap.get("name").toString());
		//userRepo.deleteUsers();
		//userRepo.deleteUser(1);
		monsterRepo.deleteMonster(monsterName);//paramMap.get("name").toString()).getId());
		return Response.noContent().build();
	}

	@PUT
	@Path("/monster")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({"application/json"})
	public Response updateUser(@QueryParam(value="name") String monsterName,@QueryParam(value="rank") int rank, Monster upMonster, @Context UriInfo uriInfo){
		//MultivaluedMap<String,String> paramMap = uriInfo.getPathParameters();
		//System.out.println("updateUser : " + paramMap.get("name").toString() + " | " + paramMap.get("upname").toString());
		
		Monster monster = monsterRepo.updateMonster(upMonster,monsterRepo.getMonster(monsterName,rank).getId());
		URI createdURI = uriInfo.getBaseUriBuilder().path("user/monster/"+monster.getId()).build();
		return Response.ok(createdURI.toString()).status(Status.CREATED).build();
	}

}