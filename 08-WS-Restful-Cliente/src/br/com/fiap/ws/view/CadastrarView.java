package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.ProdutoService;
import br.com.fiap.ws.to.Produto;

public class CadastrarView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Produto produto = new Produto();
		
//		produto.setNome("Arroz");
//		produto.setPreco(200.0);
//		produto.setDisponivel(true);
		
		
		System.out.println("Digite o nome do produto");
		produto.setNome(sc.next() + sc.nextLine());
		
		System.out.println("Preço: ");
		produto.setPreco(sc.nextDouble());
		
		System.out.println("Disponibilidade: ");
		produto.setDisponivel(sc.nextBoolean());
		
		ProdutoService service = new ProdutoService();
		try {
			service.cadastrar(produto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
