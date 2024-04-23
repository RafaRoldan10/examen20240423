package examen20240423.jpa.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import examen20240423.jpa.model.Entidad;






public class SuperControlador {
	
	private static EntityManager em = null;
	private String nombreTabla ="";
	private Class tipoEntidad;
	
	
	
	public SuperControlador(String nombreTabla, Class tipoEntidad) {
		super();
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}
	protected EntityManager getEntityManager() {
		
		if(em == null) {
			em = Persistence.createEntityManagerFactory("bankonter").
					createEntityManager();
		}
		return em;
		
	}
	public void update (Entidad m) {
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		System.out.println("Se ha actualizado");
		
	}
	
	public void insert(Entidad m) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		System.out.println("Se ha insertado");
		
	}
	
	@SuppressWarnings("unchecked")
	public List<? extends Entidad> findAll() {
		return (List<Entidad>) getEntityManager().
				createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad)
				.getResultList();
	}
	
	/**
	 * 
	 * @return
	 */
	public Entidad findFirst() {
	    try {
	        EntityManager em = getEntityManager();
	        Query q = em.createNativeQuery("SELECT * FROM " + this.nombreTabla + " ORDER BY id limit 1", this.tipoEntidad);
	        Entidad resultado = (Entidad) q.getSingleResult();
	        
	        return resultado;
	    } catch (NoResultException nrEx) {
	        return null;
	    }
	}


	/**
	 * 
	 * @return
	 */
	public Entidad findLast () {
		try {
			EntityManager em = getEntityManager();
			@SuppressWarnings("unchecked")
			Query q = em.createNativeQuery("SELECT * FROM " + this.nombreTabla + " order by id desc limit 1", this.tipoEntidad);
			Entidad resultado = (Entidad) q.getSingleResult();
			
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Entidad findNext (int id) {
		try {
			EntityManager em = getEntityManager();
			@SuppressWarnings("unchecked")
			Query q = em.createNativeQuery("SELECT * FROM " + this.nombreTabla + " where id > " + id + " order by id limit 1", this.tipoEntidad);
			
			Entidad resultado = (Entidad) q.getSingleResult();
			
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	
	
	
	/**
	 * 
	 * @return
	 */
	public Entidad findPrevious (int id) {
		try {
			EntityManager em = getEntityManager();
			@SuppressWarnings("unchecked")
			Query q = em.createNativeQuery("SELECT * FROM " + this.nombreTabla + " where id < " + id + " order by id desc limit 1", this.tipoEntidad);
			
			Entidad resultado = (Entidad) q.getSingleResult();
			
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}
	
	
	/**
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public Entidad obtencionUnaSolaEntidad (int id) {
		

		EntityManager em = getEntityManager();

		return (Entidad) em.find(this.tipoEntidad, id);
		
		
	}
	


}
