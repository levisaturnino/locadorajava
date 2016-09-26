package br.com.levisaturnino.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.levisaturnino.annotion.Categoria;
import br.com.levisaturnino.util.HibernateUtil;

public class CategoriaDAO {
	Session sessao = null;
	Transaction transacao = null;

	public void salvar(Categoria categoria) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(categoria);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel inserir o categoria. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(Categoria categoria) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(categoria);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel alterar o categoria. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualizacao. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(Categoria categoria) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(categoria);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel excluir o categoria. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}

	public Categoria buscaCategoria(Integer codigo) {

		Categoria categoria = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Categoria.class);
			filtro.add(Restrictions.eq("categoria", codigo));
			categoria = (Categoria) filtro.uniqueResult();
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
		return categoria;
	}

	public List<Categoria> listar() {

		List<Categoria> categorias = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Categoria.class);

			categorias = filtro.list();
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
		return categorias;
	}

}