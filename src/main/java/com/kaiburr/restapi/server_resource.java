package com.kaiburr.restapi;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("get_servers")
public class server_resource 
{
	server_repository repo = new server_repository();
//----------------------------------------------------------------
//get -> Fetching all resources
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Server> getServers()
	{		
		System.out.println("/Servers requested");

		return repo.getServers();
	}
		
//-----------------------------------------------------------------	
//post -> creating a resource
		@POST
		//@Path("/name:{name}&id:{id}&language{language}&framework:{framework}")
		@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Server create_server(Server s)
		{
			System.out.println("/Server create request---");
			System.out.println(s);
			
			repo.create(s);
			return s;
		}
//-----------------------------------------------------------------	
//put -> creating a resource
		@PUT
		@Path("/{name}-{id}-{language}-{framework}")
		@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Server put_create_server(@PathParam("name") String name,@PathParam("id") int id, @PathParam("language") String language,@PathParam("framework") String framework)
		{
			Server s = new Server();
			s.setName(name);
			s.setId(id);
			s.setLanguage(language);
			s.setFramework(framework);
			System.out.println("/PUT://Server create request---");
			System.out.println(s);
			repo.create(s);
			return s;
		}

//-----------------------------------------------------------------
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Server> get_server(@PathParam("id") int id)
	{		
		System.out.println("/a Server requested ::" + id);

		return repo.get_server(id);
	} 
	
//-----------------------------------------------------------------
	//delete -> deleting a resource
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Server> kill_server(@PathParam("id") int id)
	{		
		List<Server> s = repo.get_server(id);
		System.out.println("/Server killing !!  * killing is bad");
		System.out.print(s);
		Iterator iterator = s.iterator();
		if(iterator.hasNext())
		{
			repo.delete(id);
		}
		return s;
	} 


	
}


