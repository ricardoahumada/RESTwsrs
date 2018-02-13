package com.netmind.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.netmind.modelos.StatusMessage;
import com.netmind.modelos.Usuario;

@Path("/usuariosf")
public class UserServiceF extends JSONService {
	private static Logger logger = Logger.getLogger("UserServiceF");
	@Context private 
	HttpServletRequest httpRequest;
	
	@GET
	@Path("/owndata")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOwnData() {
		String email=httpRequest.getAttribute("email")!=null?(String)httpRequest.getAttribute("email"):null;
		logger.log(Level.INFO, "email:" + email);
		if(email!=null) {
			Usuario user = getUsuarioByMail(email);
			return Response.status(200).entity(user).build();
		}else return Response.status(Status.FORBIDDEN).build();
		
	}

}
