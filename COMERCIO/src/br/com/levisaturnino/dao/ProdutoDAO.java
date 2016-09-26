package br.com.levisaturnino.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.levisaturnino.produto.Produto;
import br.com.levisaturnino.util.HibernateUtil;

public class ProdutoDAO {
	Session sessao = null;
	Transaction transacao = null;

	public void salvar(Produto produto) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(produto);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel inserir o Produto. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(Produto produto) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(produto);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel alterar o Produto. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualizacao. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(Produto produto) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(produto);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel excluir o Produto. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}

	public Produto buscaProduto(Integer codigo) {

		Produto Produto = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Produto.class);
			filtro.add(Restrictions.eq("produto", codigo));
			Produto = (Produto) filtro.uniqueResult();
			this.transacao.commit();
			transacao.commit();

		} catch (Throwable e) {
			if (this.transacao.isActive()) {
				this.transacao.rollback();
			}
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de consulta. Mensagem: " + e.getMessage());
			}
		}
		return Produto;
	}

	public List<Produto> listar() {

		List<Produto> produtos = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Produto.class);

			produtos = filtro.list();
			this.transacao.commit();

		} catch (Throwable e) {
			if (this.transacao.isActive()) {
				this.transacao.rollback();
			}
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de consulta. Mensagem: " + e.getMessage());
			}
		}
		return produtos;
	}

}