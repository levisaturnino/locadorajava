package br.com.levisaturnino.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.levisaturnino.annotion.Midia;
import br.com.levisaturnino.util.HibernateUtil;

public class MidiaDAO {
	Session sessao = null;
	Transaction transacao = null;

	public void salvar(Midia midia) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(midia);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel inserir o Midia. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(Midia Midia) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(Midia);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel alterar o Midia. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualizacao. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(Midia Midia) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(Midia);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel excluir o Midia. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}

	public Midia buscaMidia(Integer codigo) {

		Midia midia = null;
		List<Midia> resultado = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Midia.class);
			filtro.add(Restrictions.eq("midia", codigo));
			midia = (Midia) filtro.uniqueResult();
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
		return midia;
	}

	public List<Midia> listar() {

		List<Midia> midias = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Midia.class);

			midias = filtro.list();
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
		return midias;
	}

}