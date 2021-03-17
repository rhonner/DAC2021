package br.com.ufpr.dac.service;

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
	@Path("/renavam/{search}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPessoaGeneric(@PathParam("search") String search) {
		List<Multa> Pessoas = multaDao.getListByRenavam(search);
		
		 		
			return Response.ok(Response.Status.OK).entity(Pessoas).build();
		

	}
	
	@GET
	@Path("/pessoa/{search}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPessoaDoc(@PathParam("search") String search) {
		List<Multa> Pessoas = multaDao.getListByDoc(search);
		if(Pessoas.isEmpty()) {
			return Response.noContent().build();
		}
		else {			
			return Response.ok(Response.Status.OK).entity(Pessoas).build();
		}

	}

	@GET
	@Path("/{id}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMulta(@PathParam("id") int id) {
		Multa multa = multaDao.getById(id);
		System.out.print(multa);
		if(multa != null) {
			return Response
					.ok(Response.Status.OK)
					.entity(multa)
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
	public Response InserirMulta(Multa multa) {
		if(multa.getDatamulta() == null || multa.getRenavam().isEmpty() || multa.getDocumento().isEmpty()) {
			return Response.notAcceptable(null).entity(JsonCamposNulos()).build();
		}
		else {
			multaDao.inserir(multa);
			return Response.ok().entity(JsonInsercaoRealizadaComSucesso()).build();
		}
	}
	
	@PUT
	@Path("/alterar")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AlterarMulta(Multa multa) {
		if(multa.getDatamulta() == null || multa.getRenavam().isEmpty() || multa.getDocumento().isEmpty()) {
			return Response.notAcceptable(null).entity(JsonCamposNulos()).build();
		}
		else {
			multaDao.alterar(multa);
			return Response.ok().build();			
		}
	}
	
	@DELETE
	@Path("/excluir/{id}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ExcluirMulta(@PathParam("id") int id) {
		Multa multa = multaDao.getById(id);
		if(multa == null) {
			return Response.notModified().entity(JsonMultaNaoLocalizada()).build();
		}
		multaDao.excluir(multa);
		return Response.ok().build();
	}

	private String JsonNenhumResultadoEncontrado() {
		return "{\"message\" : " + "\"nenhum resultado encontrado!\"" + " }";
	}

	private String JsonInsercaoRealizadaComSucesso() {
		return "{\"message\" : " + "\"Inserção realizada com sucesso!\"" + " }";
	}
	
	private String JsonCamposNulos() {
		return "{\"message\" : " + "\"Data da multa, documento e renavam devem ser preenchidos!\"" + " }";
	}
	
	private String JsonMultaNaoLocalizada() {
		return "{\"message\" : " + "\"Não foi possível localizar a multa a ser excluída.\"" + " }";
	}
}