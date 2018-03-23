package br.com.fiap.ws.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.ws.service.ProdutoService;
import br.com.fiap.ws.to.Produto;

public class BuscaView {
public static void main(String[] args) {
		
		ProdutoService service = new ProdutoService();
		
		try {
			List<Produto> lista = service.listar();
			for (Produto produto : lista) {
				System.out.println(produto.getNome());
				System.out.println(produto.getPreco());
				System.out.println(produto.isDisponivel());
				System.out.println("= = = = = = = = =  = = = ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
