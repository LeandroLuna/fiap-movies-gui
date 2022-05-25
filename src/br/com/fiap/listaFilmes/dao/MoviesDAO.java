package br.com.fiap.listaFilmes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.listaFilmes.model.MoviesList;

public class MoviesDAO {

	EntityManager manager = JpaManager.getManager();
	
	public void insert(MoviesList filme) {
			
			manager.getTransaction().begin();
			manager.persist(filme);
			manager.getTransaction().commit();
	
		
	}
	
	public List<MoviesList> showAll() {
		TypedQuery<MoviesList> query = 
				manager.createQuery("SELECT l FROM MoviesList l", MoviesList.class);
		return query.getResultList();

	}
	
	public void delete(MoviesList filme) {
		manager.getTransaction().begin();
		manager.remove(filme);
		manager.getTransaction().commit();
	}

	public void deleteId(Long id) {
		delete(searchId(id));
	}

	public MoviesList searchId(Long id) {
		return manager.find(MoviesList.class, id);
	}
	
	
}
