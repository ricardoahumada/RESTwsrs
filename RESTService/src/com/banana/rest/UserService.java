package com.banana.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.banana.models.Usuario;

@Path("/users")
@Consumes({ "application/json" })
@Produces(MediaType.APPLICATION_JSON)
public class UserService {
	private static final Logger logger = Logger.getLogger(UserService.class.getName());

	private static List<Usuario> listaUsers = null;

	static {
		listaUsers = new ArrayList<Usuario>();

		for (int i = 0; i < 5; i++) {
			listaUsers.add(new Usuario(i, "Usuario " + i, "Apellido " + i, "Email " + i, ""));
		}
	}

	@GET
	@Path("/")
	public List<Usuario> getUsuario() {
		return listaUsers;
	}

	@GET
	@Path("/{uid}")
	public Response getUser(@PathParam("uid") int uid) {
		logger.info("getUser:" + uid);

		Usuario resultUser = new Usuario();

		for (Usuario usuario : listaUsers) {
			if (usuario.getUid() == uid) {
				resultUser = usuario;
				break;
			}
		}

		logger.info("getUser:" + resultUser);

		return Response.ok(resultUser).build();
	}
	
	@POST
	@Path("/add")
	public Response addUser(Usuario newUser) {
		boolean isOK=false;
		
		newUser.setUid(new Date().getTime());
		listaUsers.add(newUser);
		return Response.ok("{\"result\":"+isOK+"}").build();
	}
	
	@PUT
	@Path("/{uid}")
	public Response addUser(@PathParam("uid") int uid, Usuario aUser) {
		boolean isOK=false;
		
		for (int i = 0; i < listaUsers.size(); i++) {
			if(listaUsers.get(i).getUid()==uid) {listaUsers.set(i, aUser); isOK=true; break;}
		}
		
		return Response.ok("{\"result\":"+isOK+"}").build();
	}
	
	@DELETE
	@Path("/{uid}")
	public Response deleteUser(@PathParam("uid") int uid) {
		boolean isOK=false;
		
		for (int i = 0; i < listaUsers.size(); i++) {
			if(listaUsers.get(i).getUid()==uid) {listaUsers.remove(i); isOK=true; break;}
		}
		
		return Response.ok("{\"result\":"+isOK+"}").build();
	} 
	
	
}
