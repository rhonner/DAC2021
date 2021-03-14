package br.com.ufpr.dac.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.ufpr.dac.dao.InfracaoDao;
import br.com.ufpr.dac.persistence.Infracao;

@Path("/infracao")
public class InfracaoResource {
	InfracaoDao InfracaoDao;
	@Context
	private UriInfo context;

	public InfracaoResource() {
		InfracaoDao = new InfracaoDao();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response get() {
		List<Infracao> Infracaos = InfracaoDao.getList();
		if(Infracaos.isEmpty()) {
			return Response.noContent().build();
		}
		else {			
			return Response.ok(Response.Status.OK).entity(Infracaos).build();
		}
	}

	@GET
	@Path("/{id}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getInfracao(@PathParam("id") int id) {
		Infracao Infracao = InfracaoDao.getById(id);
		System.out.print(Infracao);
		if(Infracao != null) {
			return Response
					.ok(Response.Status.OK)
					.entity(Infracao)
					.build();

		}
		else {
			return Response.ok(Response.Status.NO_CONTENT).entity(JsonNenhumResultadoEncontrado()).build();
		}

	}

	@POST
	@Path("/inserir")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response InserirInfracao(Infracao Infracao) {
		InfracaoDao.inserir(Infracao);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/alterar")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AlterarInfracao(Infracao Infracao) {
		InfracaoDao.alterar(Infracao);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/excluir/{id}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ExcluirInfracao(@PathParam("id") int id) {
		Infracao Infracao = InfracaoDao.getById(id);
		InfracaoDao.excluir(Infracao);
		return Response.ok().build();
	}

	private String JsonNenhumResultadoEncontrado() {
		return "{\"message\" : " + "\"nenhum resultado encontrado!\"" + " }";
	}

	private String JsonInsercaoRealizadaComSucesso() {
		return "{\"message\" : " + "\"Inserção realizada com sucesso!\"" + " }";
	}
}
