package br.com.levisaturnino.main;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import br.com.levisaturnino.annotion.Categoria;
import br.com.levisaturnino.annotion.Cliente;
import br.com.levisaturnino.annotion.Endereco;
import br.com.levisaturnino.annotion.Filme;
import br.com.levisaturnino.annotion.Locacao;
import br.com.levisaturnino.annotion.Midia;
import br.com.levisaturnino.dao.CategoriaDAO;
import br.com.levisaturnino.dao.ClienteDAO;
import br.com.levisaturnino.dao.EnderecoDAO;
import br.com.levisaturnino.dao.FilmeDAO;
import br.com.levisaturnino.dao.LocacaoDAO;
import br.com.levisaturnino.dao.MidiaDAO;
import br.com.levisaturnino.util.HibernateUtil;

public class Locadora {

	public static void main(String[] args) {

		HibernateUtil.getSessionFactory().openSession();

		Locadora locadora = new Locadora();

		locadora.cadastraCategorias();
		locadora.cadastraFilmes();
		locadora.cadastraMidias();

		EnderecoDAO enderecoDAO = new EnderecoDAO();

		Endereco endereco = new Endereco();

		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();

		cliente.setCelular("(47) 1111-2222");
		cliente.setEmail("solaris@javapro.com.br");
		cliente.setNome("Fulano Solaris");
		cliente.setTelefone("(47) 3333-7777");
		cliente.setEndereco(endereco);

		endereco.setBairro("centro");
		endereco.setCep("89999-999");
		endereco.setCidade("Joinville");
		endereco.setComplemento("casa");
		endereco.setNumero(new Integer(1));
		endereco.setRua("Av. Principal");
		endereco.setUf("SC");
		endereco.setCliente(cliente);
		clienteDAO.salvar(cliente);
		enderecoDAO.salvar(endereco);

		LocacaoDAO locacaoDAO = new LocacaoDAO();

		Locacao locacao = new Locacao();

		locacao.setDataDevolucao(new Date(System.currentTimeMillis()));
		locacao.setDataEmprestimo(new Date(System.currentTimeMillis()));

		locacao.setObservacao("Devolucao final de semana");
		locacao.setHoraEmprestimo(new Time(System.currentTimeMillis()));

		locacao.setCliente(cliente);

		MidiaDAO midiaDAO = new MidiaDAO();
		
		Midia midia = (Midia) midiaDAO.buscaMidia(new Integer(2));
		
		locacao.setMidia(midia);
		locacaoDAO.salvar(locacao);
		
		
		System.out.println("Cadastros gerados com sucesso!");
	}

	private void cadastraCategorias() {

		String categorias[] = { "Aventura", "Ação", "Comédia" };
		Categoria categoria = null;
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		for (int i = 0; i < 3; i++) {
			categoria = new Categoria();
			categoria.setDescricao(categorias[i]);
			categoriaDAO.salvar(categoria);

		}

	}

	private void cadastraFilmes() {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		String[] filmeDescricao = { "Senhor dos Anéis", "Transformes", "Ghostbusters" };
		Date[] filmeAnoProducao = { new Date(2001 - 1900, 11, 19), new Date(2007 - 1900, 6, 20),
				new Date(1985 - 1900, 1, 1) };
		FilmeDAO filmeDAO = new FilmeDAO();

		Filme filme = null;

		for (int i = 0; i < 3; i++) {
			filme = new Filme();
			filme.setDescricao(filmeDescricao[i]);
			filme.setAno(filmeAnoProducao[i]);
			filme.setCategoria(categoriaDAO.buscaCategoria(i + 1));
			filmeDAO.salvar(filme);
		}

	}

	private void cadastraMidias()
	{
		Midia midia = null;
		Filme filme = null;
		MidiaDAO midiaDAO = new MidiaDAO();
		FilmeDAO filmeDAO = new FilmeDAO();

		List<Filme> resultado = filmeDAO.listar();

		for (int i = 0; i < 3; i++) {
			midia = new Midia();
			filme = (Filme) resultado.get(i);
			midia.setFilme(filme);
			midia.setInutilizada("N");
			midiaDAO.salvar(midia);
		}
	}

}
