package br.com.ufpr.dac.impl;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import br.com.ufpr.dac.bean.UsuarioBean;
import br.com.ufpr.dac.response.UsuarioResponse;

public class UsuarioImpl {
	private static String path = "/usuario";

	public UsuarioImpl() {
	}

	public List<UsuarioResponse> getListaUsuario() {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path);
		Response response = responseConfig.getClient().get();
		if (response.getStatus() == 200) {
			List<UsuarioResponse> retorno = response.readEntity(new GenericType<List<UsuarioResponse>>() {
			});
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

	public UsuarioResponse getUsuario(int id) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + '/' + id);
		Response response = responseConfig.getClient().get();
		if (response.getStatus() == 200) {
			UsuarioResponse retorno = response.readEntity(UsuarioResponse.class);
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

	public Boolean inserirUsuario(UsuarioResponse usuario) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/inserir");
		if (!usuario.getLogin().isEmpty() && !usuario.getSenha().isEmpty()) {
			Response response = responseConfig.getClient().post(Entity.json(usuario));
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

	public Boolean alterarUsuario(UsuarioResponse usuario) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/alterar");
		if (!usuario.getLogin().isEmpty() && !usuario.getSenha().isEmpty()) {
			Response response = responseConfig.getClient().put(Entity.json(usuario));
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

	public UsuarioResponse excluirUsuario(int id) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/excluir/" + id);
		Response response = responseConfig.getClient().delete();
		if (response.getStatus() == 200) {
			UsuarioResponse retorno = response.readEntity(UsuarioResponse.class);
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

}
