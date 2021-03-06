package br.com.levisaturnino.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			//Configuration cfg = new Configuration();
			Configuration cfg = new Configuration();

			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();

		} catch (Throwable e) {
			System.out.println("Criação inicial do objeto SessionFacory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
