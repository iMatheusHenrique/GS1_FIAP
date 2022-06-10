package br.com.fiap.posto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.posto.model.Posto;

public class PostoDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Posto");
	EntityManager manager = factory.createEntityManager();

	public void insert(Posto posto) {

		manager.getTransaction().begin();
		manager.persist(posto);
		manager.getTransaction().commit();

	}

	public List<Posto> listarTodos() {
		String jpql = "SELECT p FROM Posto p";
		TypedQuery<Posto> query = manager.createQuery(jpql, Posto.class);

		return query.getResultList();
	}
	
	public List<Posto> listarPorEstado() {
		String jpql = "SELECT p FROM Posto p order by p.estado";
		TypedQuery<Posto> query = manager.createQuery(jpql, Posto.class);

		return query.getResultList();
	}

	public void delete(Posto posto) {
		manager.getTransaction().begin();
		manager.remove(posto);
		manager.getTransaction().commit();
	}
	
	public Posto find(Long id) {
		return manager.find(Posto.class, id);
	}

}
