package br.com.fiap.ws.service;

import java.util.Scanner;

import br.com.fiap.ws.to.Produto;

public class RemoverView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Produto produto = new Produto();
		
		System.out.println("Digite o codigo para a exclusao");
		int codigo = sc.nextInt();
		
		ProdutoService service = new ProdutoService();
		
		service.remover(codigo);
		sc.close();
	}
}
