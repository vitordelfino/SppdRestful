package br.com.sppd.resource;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.sppd.controller.EstacaoController;

public class RetornoResponse {
	
	Response ok(Object object){
		
		return Response.status(200)
				.entity(new Gson().toJson(object))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token")
				.build();		
	}

}
