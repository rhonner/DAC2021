package br.com.ufpr.dac.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.ufpr.dac.dao.MultaDao;
import br.com.ufpr.dac.persistence.Multa;
import java.util.List;

@Path("multa")
public class MultaResource {
	MultaDao multaDao;
	@Context
	private UriInfo context;

	public MultaResource() {
		multaDao = new MultaDao();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response get() {
		List<Multa> multas = multaDao.getList();
		if(multas.isEmpty()) {
			return Response.noContent().build();
		}
		else {			
			return Response.ok(Response.Status.OK).entity(multas).build();
		}
	}

	@GET
    @Path("/{id}")  
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response getMulta(@PathParam("id") int id) {
		Multa multa = multaDao.getById(id);
			if(multa != null) {
				return Response
						.ok(Response.Status.OK)
						.entity(multa)
						.build();
				
			}
			else {
				return Response.noContent().build();
			}
				
	}
}
