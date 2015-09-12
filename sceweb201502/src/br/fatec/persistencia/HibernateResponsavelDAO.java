package br.fatec.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import br.fatec.dominio.Responsavel;

public class HibernateResponsavelDAO implements IResponsavelDAO {
		Logger logger = Logger.getLogger(HibernateResponsavelDAO.class);
		@Override
		public String cadastra(Responsavel r) throws PersistenceException{

			logger.info("inicializando a transacao cadastra");
			String codigoRetorno = "";
			try {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
				EntityManager em = factory.createEntityManager();
				em.getTransaction().begin();
				em.persist(r);
				em.getTransaction().commit();
				em.close();
				codigoRetorno = "Cadastro realizado com sucesso";
			} catch (PersistenceException exception) { // HibernateException
				codigoRetorno = "Erro no cadastro";
				logger.error("disparou um erro na transacao de persistencia do tipo " + exception.getMessage());
				codigoRetorno = exception.getMessage();
			}
			return codigoRetorno;
		}
		public Responsavel consulta(Responsavel r) {
			
			logger.info("inicializando a transacao consulta");
			Responsavel resp = null;

			try {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
				EntityManager em = factory.createEntityManager();
				em.getTransaction().begin();
				resp = em.find(Responsavel.class, r.getCnpj());
				em.getTransaction().commit();
			} catch (HibernateException exception) {
				exception.printStackTrace();
				logger.error("disparou um erro na transacao de consulta do tipo " + exception.toString());
			}
			return resp;
		}
		public int exclui(String cnpj) {

			logger.info("inicializando a transacao exclui");
			int codigoRetorno = 0;
			try {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("sceweb");
				EntityManager em = factory.createEntityManager();

				String jpql = " DELETE FROM Responsavel e WHERE e.cnpj = :cnpj";
				em.getTransaction().begin();
				Query query = em.createQuery(jpql);
				query.setParameter("cnpj", cnpj);
				codigoRetorno = query.executeUpdate();
				logger.info(" resultado da query exclui cnpj ="+ cnpj + " e codigoRetorno =" + codigoRetorno + " excluido");
				em.getTransaction().commit();
			} catch (HibernateException exception) {
				exception.printStackTrace();
			}
			return codigoRetorno;
		}

}
