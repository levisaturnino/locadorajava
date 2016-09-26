package br.com.levisaturnino.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.levisaturnino.annotion.Endereco;
import br.com.levisaturnino.util.HibernateUtil;

public class EnderecoDAO {
	Session sessao = null;
	Transaction transacao = null;

	public void salvar(Endereco endereco) {
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(endereco);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel inserir o Endereco. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void atualizar(Endereco endereco) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(endereco);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel alterar o Endereco. Erro: " + e.getMessage());
		} finally {
			try {
				if (this.sessao.isOpen())
					sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de atualizacao. Mensagem: " + e2.getMessage());
			}
		}
	}

	public void excluir(Endereco endereco) {

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(endereco);
			transacao.commit();
		} catch (Exception e) {
			System.out.println("Não foi possivel excluir o Endereco. Erro: " + e.getMessage());
		} finally {
			try {
				sessao.close();
			} catch (Throwable e2) {
				System.out.println("Erro ao fechar operação de excluir. Mensagem: " + e2.getMessage());
			}
		}
	}

	public Endereco buscaEndereco(Integer codigo) {

		Endereco endereco = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Endereco.class);
			filtro.add(Restrictions.eq("Endereco", codigo));
			endereco = (Endereco) filtro.uniqueResult();
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
		return endereco;
	}

	public List<Endereco> listar() {

		List<Endereco> enderecos = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria filtro = sessao.createCriteria(Endereco.class);

			enderecos = filtro.list();
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
		return enderecos;
	}

}