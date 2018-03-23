package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Produto;

public class ProdutoService {
	
	private Client client = Client.create();
	private static final String URL = "http://localhost:8080/07-WS-Restful-Server/rest/produto";
	
	public void cadastrar(Produto produto) throws Exception{
		WebResource w = client.resource(URL);
		
		ClientResponse response = w.type("application/json").
				post(ClientResponse.class, produto);
		
		if (response.getStatus() != 200) {
			System.out.println("Sucesso!\nO produto foi cadastrado. \n" + response.getLocation());
		}
		else {
			System.err.println("Erro HTTP code: " + response.getStatus());
		}
	}
	
	
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
	
	public List<Produto> listar() {
		WebResource w = client.resource(URL);
		ClientResponse response = 
				w.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		return Arrays.asList(response.getEntity(Produto[].class));
	}
	
	public void remover(int codigo) {
		WebResource w = client.resource(URL).path(String.valueOf(codigo));
		ClientResponse response = w.delete(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			System.out.println("Sucesso! O produto foi deletado!\n" + response.getLocation());
		}
		else {
			System.err.println("Erro HTTP code: " + response.getStatus());
		}
	}
	
	public void atualizar(Produto produto) {
		//Pegando pela URL o codigo do cliente
		WebResource w = client.resource(URL).path(String.valueOf(produto.getCodigo()));
		ClientResponse response = w.put(ClientResponse.class, produto);
		
		if (response.getStatus() != 200) {
			System.out.println("Sucesso! O produto foi atualizado!\n" + response.getLocation());
		}
		else {
			System.err.println("Erro HTTP code: " + response.getStatus());
		}
	}
	
}
