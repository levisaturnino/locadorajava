package br.com.levisaturnino.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.levisaturnino.categoria.Categoria;
import br.com.levisaturnino.dao.CategoriaDAO;
import br.com.levisaturnino.dao.ProdutoDAO;
import br.com.levisaturnino.produto.Produto;

public class Cadastro {

	public static void main(String[] args) {
		Cadastro cadastro = new Cadastro();

		cadastro.cadastraProdutos();
		cadastro.cadastraCategoria();
		System.out.println("Cadastros gerados com suecesso!");
	}

	private void cadastraCategoria() {
	String descricao[] = {"Utilidades","Geral"};
	CategoriaDAO categoriaDAO = new CategoriaDAO();
	Categoria categoria = null;
	
	ProdutoDAO produtoDAO = new ProdutoDAO();
	Set<Produto> produtos = new HashSet<>();
	List<Produto> produtosListagem = produtoDAO.listar();
	
	for (int i = 0; i < produtosListagem.size();i++) {
		produtos.add(produtosListagem.get(i));
	}
		
	for (int j = 0; j < 2; j++) {
		categoria = new Categoria();
		categoria.setDescricao(descricao[j]);
		categoria.setProdutos(produtos);
		categoriaDAO.salvar(categoria);
	}
	}

	private void cadastraProdutos() {
		String descricao[] = { "Bicicleta", "Televisão", "DVD" };
		Double preco[] = { 356.83, 19.99, 195.60 };
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = null;

		for (int i = 0; i < 3; i++) {
			produto = new Produto();
			produto.setDescricao(descricao[i]);
			produto.setPreco(preco[i]);
			produtoDAO.salvar(produto);

		}

	}

}
