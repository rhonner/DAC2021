package br.com.ufpr.dac.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ResponseConfiguration {
	private String path;
	private Builder client;
	
	public ResponseConfiguration(String endPoint) {
		path = "http://localhost:8080/tadstrans/webresource" + endPoint;
		client = ClientBuilder.newClient().target(path).request(MediaType.APPLICATION_JSON);
	}
	
	public Builder getClient() {
		return this.client;
	}
}	

	
	