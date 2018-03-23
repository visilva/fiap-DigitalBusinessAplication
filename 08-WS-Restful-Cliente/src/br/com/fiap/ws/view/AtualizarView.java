package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.service.ProdutoService;
import br.com.fiap.ws.to.Produto;

public class AtualizarView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Produto produto = new Produto();
		
		System.out.println("Insira o código do produto");
		produto.setCodigo(sc.nextInt());
		
		System.out.println("Nome: ");
		produto.setNome(sc.next() + sc.nextLine());
		
		System.out.println("Insira o novo preço do produto");
		produto.setPreco(sc.nextDouble());
		
		System.out.println("Insira a nova disponibilidade do produto");
		produto.setDisponivel(sc.nextBoolean());
		
		ProdutoService service = new ProdutoService();
		
		service.atualizar(produto);
		System.out.println("Atualizado!");
		
		sc.close();
	}
}
