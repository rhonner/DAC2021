package br.com.ufpr.dac.service;

import java.time.LocalDate;
import java.time.Period;
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

import br.com.ufpr.dac.dao.PagamentoDao;
import br.com.ufpr.dac.persistence.Pagamento;

@Path("/pagamento")
public class PagamentoResource {
	PagamentoDao PagamentoDao;
	@Context
	private UriInfo context;

	public PagamentoResource() {
		PagamentoDao = new PagamentoDao();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response get() {
		List<Pagamento> Pagamentos = PagamentoDao.getList();
		if (Pagamentos.isEmpty()) {
			return Response.noContent().build();
		} else {
			return Response.ok(Response.Status.OK).entity(Pagamentos).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPagamento(@PathParam("id") int id) {
		Pagamento Pagamento = PagamentoDao.getById(id);
		System.out.print(Pagamento);
		if (Pagamento != null) {
			return Response.ok(Response.Status.OK).entity(Pagamento).build();

		} else {
			return Response.ok(Response.Status.NO_CONTENT).entity(JsonNenhumResultadoEncontrado()).build();
		}

	}

	@POST
	@Path("/inserir")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response InserirPagamento(Pagamento Pagamento) {
		PagamentoDao.inserir(Pagamento);
		return Response.ok().build();
	}

	@PUT
	@Path("/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AlterarPagamento(Pagamento Pagamento) {
		PagamentoDao.alterar(Pagamento);
		return Response.ok().build();
	}

	@DELETE
	@Path("/excluir/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ExcluirPagamento(@PathParam("id") int id) {
		Pagamento Pagamento = PagamentoDao.getById(id);
		PagamentoDao.excluir(Pagamento);
		return Response.ok().build();
	}

	private String JsonNenhumResultadoEncontrado() {
		return "{\"message\" : " + "\"nenhum resultado encontrado!\"" + " }";
	}

	private String JsonInsercaoRealizadaComSucesso() {
		return "{\"message\" : " + "\"Inserção realizada com sucesso!\"" + " }";
	}

	private float AjustarValor(Pagamento pagamento) {
		Period period = Period.between(pagamento.getMulta().getDatamulta().toLocalDateTime().toLocalDate(), LocalDate.now());
		int meses = period.getMonths();
		int dias = period.getDays();
		float valor = pagamento.getValor();
		if(dias >= 30) {
			int mesesEmAtraso = dias/30;
			float jurosMora = (float) (valor * 0.2);
			float total = valor + jurosMora;
			valor = (float) (total + (total + (0.1 * mesesEmAtraso)));
		}
		return valor;
	}
}
