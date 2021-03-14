package br.com.ufpr.dac.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;

public class ResponseConfiguration {
	private String path;
	private Builder client;
	
	public ResponseConfiguration(String endPoint) {
		path = "http://localhost:8180/tadstran/webresources" + endPoint;
		client = ClientBuilder.newClient().register(ResteasyJackson2Provider.class).target(path).request(MediaType.APPLICATION_JSON);
	}
	
	public Builder getClient() {
		return this.client;
	}
}	

	
	