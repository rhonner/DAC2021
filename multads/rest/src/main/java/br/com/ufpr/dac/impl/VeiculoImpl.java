package br.com.ufpr.dac.impl;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import br.com.ufpr.dac.response.VeiculoResponse;

public class VeiculoImpl {
	private static String path = "/veiculo";

	public VeiculoImpl() {
	}

	public List<VeiculoResponse> getListaVeiculo() {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path);
		Response response = responseConfig.getClient().get();
		if (response.getStatus() == 200) {
			List<VeiculoResponse> retorno = response.readEntity(new GenericType<List<VeiculoResponse>>() {
			});
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

	public VeiculoResponse getVeiculo(int id) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + '/' + id);
		Response response = responseConfig.getClient().get();
		if (response.getStatus() == 200) {
			VeiculoResponse retorno = response.readEntity(VeiculoResponse.class);
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

	public Boolean inserirVeiculo(VeiculoResponse veiculo) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/inserir");
		if (!veiculo.getChassi().isEmpty() && !veiculo.getPlaca().isEmpty() && !veiculo.getRenavam().isEmpty()) {
			Response response = responseConfig.getClient().post(Entity.json(veiculo));
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

	public Boolean alterarVeiculo(VeiculoResponse veiculo) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/alterar");
		if (!veiculo.getChassi().isEmpty() && !veiculo.getPlaca().isEmpty() && !veiculo.getRenavam().isEmpty()) {
			Response response = responseConfig.getClient().put(Entity.json(veiculo));
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

	public VeiculoResponse excluirVeiculo(int id) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/excluir/" + id);
		Response response = responseConfig.getClient().delete();
		if (response.getStatus() == 200) {
			VeiculoResponse retorno = response.readEntity(VeiculoResponse.class);
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

}
