package br.com.levisaturnino.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.levisaturnino.annotion.Locacao;
import br.com.levisaturnino.util.HibernateUtil;

public class LocacaoDAO {
	Session sessao = null;
	Transaction transacao = null;

	public void salvar(Locacao locacao) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(locacao);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel inserir o Locacao. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(Locacao locacao) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(locacao);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel alterar o Locacao. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualizacao. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(Locacao locacao) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(locacao);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel excluir o Locacao. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}

	public Locacao buscaLocacao(Integer codigo) {

		Locacao locacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Locacao.class);
			filtro.add(Restrictions.eq("Locacao", codigo));
			locacao = (Locacao) filtro.uniqueResult();
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
		return locacao;
	}

	public List<Locacao> listar() {

		List<Locacao> locacaos = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Locacao.class);

			locacaos = filtro.list();
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
		return locacaos;
	}

}