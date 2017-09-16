package br.com.mfoxsistemas.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import br.com.mfoxsistemas.model.ComoTrabalhamos;

public class ComoTrabalhamosDao {

	private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("MFOXSistemasPU");
	
	private EntityManager em = factory.createEntityManager();
	
	public ComoTrabalhamos inserir(ComoTrabalhamos comoTrabalhamos) throws HibernateException , SQLException{
		em.getTransaction().begin();    
		em.persist(comoTrabalhamos);
		em.getTransaction().commit();  
		return comoTrabalhamos;
	}
}
