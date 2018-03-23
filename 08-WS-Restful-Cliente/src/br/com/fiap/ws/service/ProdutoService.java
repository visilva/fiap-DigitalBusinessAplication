package br.com.fiap.ws.service;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Produto;

public class ProdutoService {
	
	private Client client = Client.create();
	private static final String URL = "http://localhost:8080/07-WS-Restful-Server/rest/produto";
	
	public Produto pesquisar(int codigo) throws Exception {
		WebResource w = client.resource(URL).path
				(String.valueOf(codigo));
		
		//Chama o webservice
		ClientResponse response = 
				//Recebe o JSON
				w.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		//Valida se deu certo
		if (response.getStatus() != 200) {
			throw new Exception("Erro" + response.getStatus());
		}
		//Quando for uma lista, deveria ser um array, tipo Produto[].class
		return response.getEntity(Produto.class);
		
	}
	
	
	
}
