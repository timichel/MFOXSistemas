package br.com.mfoxsistemas.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.com.mfoxsistemas.model.QuemSomos;

public class QuemSomosDao {

	private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("MFOXSistemasPU");
	
	private EntityManager em = factory.createEntityManager();
	
	public void getEntityManager(){
		if(em == null)
			em = factory.createEntityManager();
	}
	
	public void Disconnect() {
		if(em.getTransaction().isActive())
			em.getTransaction().commit();
		
	}
	
	public QuemSomos inserir(QuemSomos quemSomos) throws HibernateException , SQLException{
		getEntityManager();
		em.getTransaction().begin();
		QuemSomos quemSomosSalva = new QuemSomos();
		quemSomosSalva = quemSomos;
		em.merge(quemSomos);
		em.getTransaction().commit();  
		return quemSomosSalva;
	}
	
	@SuppressWarnings("unchecked")
	public List<QuemSomos> getQuemSomos() throws HibernateException , SQLException{
		getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("QuemSomos.findAll");
		return query.getResultList();
	}
	
	public QuemSomos getQuemSomosById(int id) throws HibernateException , SQLException{
		getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("QuemSomos.findById")
				.setParameter("Id", id);
		return (QuemSomos) query.getSingleResult();
	}
	
	public QuemSomos getQuemSomosAtivo() throws HibernateException , SQLException{
		getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("QuemSomos.findAtivo")
				.setParameter("Ativo", true);
		return (QuemSomos) query.getSingleResult();
	}

	public void excluir(int id) throws HibernateException , SQLException{
		getEntityManager();
		em.getTransaction().begin();
		QuemSomos quemSomosExcluir = new QuemSomos();
		Query query = em.createNamedQuery("QuemSomos.findById")
				.setParameter("Id", id);
		quemSomosExcluir = (QuemSomos) query.getSingleResult();
		em.remove(quemSomosExcluir);
		em.getTransaction().commit();
		
	}

	public QuemSomos setQuemSomosAtivo(int id) {
		getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("QuemSomos.findById")
				.setParameter("Id", id);
		QuemSomos quemSomosAtivo = new QuemSomos();
		quemSomosAtivo = (QuemSomos) query.getSingleResult();
		quemSomosAtivo.setAtivo(true);
		em.merge(quemSomosAtivo);
		em.getTransaction().commit();
		return quemSomosAtivo;
	}

	public void setQuemSomosInativo() {
		getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("QuemSomos.updateInativo");
		query.executeUpdate();
		em.getTransaction().commit();
	}

}
