package br.com.ufpr.dac.impl;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import br.com.ufpr.dac.response.PessoaResponse;

public class PessoaImpl {
	private static String path = "/pessoa";

	public PessoaImpl() {
	}

	public List<PessoaResponse> getListaPessoa() {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path);
		Response response = responseConfig.getClient().get();
		if (response.getStatus() == 200) {
			List<PessoaResponse> retorno = response.readEntity(new GenericType<List<PessoaResponse>>() {
			});
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

	public List<PessoaResponse> getListaPessoaGenericSearch(String search) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + '/' +"genericSearch"+'/'+ search);
		Response response = responseConfig.getClient().get();
		if (response.getStatus() == 200) {
			List<PessoaResponse> retorno = response.readEntity(new GenericType<List<PessoaResponse>>() {
			});
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}
	
	public PessoaResponse getPessoa(int id) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + '/' + id);
		Response response = responseConfig.getClient().get();
		if (response.getStatus() == 200) {
			PessoaResponse retorno = response.readEntity(PessoaResponse.class);
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

	public Boolean inserirPessoa(PessoaResponse pessoa) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/inserir");
		if (!pessoa.getNome().isEmpty() && !pessoa.getDocumento().isEmpty()) {
			Response response = responseConfig.getClient().post(Entity.json(pessoa));
			if (response.getStatus() == 200) {
				return true;
			} else {
				String retorno = response.readEntity(String.class);
				return false;
			}
		} else {
			return false;
		}
	}

	public Boolean alterarPessoa(PessoaResponse pessoa) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/alterar");
		if (!pessoa.getNome().isEmpty() && !pessoa.getDocumento().isEmpty()) {
			Response response = responseConfig.getClient().put(Entity.json(pessoa));
			if (response.getStatus() == 200) {
				return true;
			} else {
				String retorno = response.readEntity(String.class);
				return false;
			}
		} else {
			return false;
		}
	}

	public PessoaResponse excluirPessoa(int id) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/excluir/" + id);
		Response response = responseConfig.getClient().delete();
		if (response.getStatus() == 200) {
			PessoaResponse retorno = response.readEntity(PessoaResponse.class);
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

}
