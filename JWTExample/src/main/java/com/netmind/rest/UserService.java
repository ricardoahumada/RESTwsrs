package com.netmind.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.netmind.modelos.StatusMessage;
import com.netmind.modelos.Usuario;

@Path("/usuarios")
public class UserService extends JSONService{
	private static Logger logger = Logger.getLogger("UserService");
	
	@GET
	@Path("/owndata")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOwnData(@HeaderParam("token") String token) {
		logger.log(Level.INFO, "token:" + token);
		String userEmail = "";

		userEmail = this.getUserEmailFromToken(token);
		logger.log(Level.INFO, "userEmail:" + userEmail);

		if (userEmail == null) {
			StatusMessage statusMessage = new StatusMessage();
			statusMessage.setStatus(Status.FORBIDDEN.getStatusCode());
			statusMessage.setMessage("Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		}

		Usuario user;
		user = getUsuarioByMail(userEmail);

		return Response.status(200).entity(user).build();
	}
	
}
