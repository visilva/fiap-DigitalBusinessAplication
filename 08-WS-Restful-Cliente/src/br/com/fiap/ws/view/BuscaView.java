package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.ProdutoService;
import br.com.fiap.ws.to.Produto;

public class BuscaView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o codigo...");
		int codigo = sc.nextInt();
		
		ProdutoService service = new ProdutoService();
		
		try {
			Produto produto = service.pesquisar(codigo);
			System.out.println(produto.getNome());
			System.out.println(produto.getPreco());
			System.out.println(produto.isDisponivel());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
		
	}
}
