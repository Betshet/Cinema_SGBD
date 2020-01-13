package controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.IndoorScene;
import model.Location;

public class DAOIndoorScene {
	
	EntityManagerFactory entityManagerFactory;
	
	
	public DAOIndoorScene(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	public ArrayList<IndoorScene> findAllIndoorScene()
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		ArrayList<IndoorScene> resultat = new ArrayList<IndoorScene>();
		String queryString = "select ids from IndoorScene ids";
		Query query = em.createQuery(queryString);
		ArrayList<IndoorScene> results = (ArrayList<IndoorScene>) query.getResultList();
		
		for (int i = 0; i < results.size(); i++) {
			resultat.add((IndoorScene) results.get(i));
		}
		em.getTransaction().commit();
		em.close();
		return resultat;
	}

}
