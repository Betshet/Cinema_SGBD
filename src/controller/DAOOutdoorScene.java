package controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.OutdoorScene;

public class DAOOutdoorScene {

	EntityManagerFactory entityManagerFactory;
	
	
	public DAOOutdoorScene(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	public ArrayList<OutdoorScene> findAllOutdoorScene()
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		ArrayList<OutdoorScene> resultat = new ArrayList<OutdoorScene>();
		String queryString = "select os from OutdoorScene os";
		Query query = em.createQuery(queryString);
		ArrayList<OutdoorScene> results = (ArrayList<OutdoorScene>) query.getResultList();
		
		for (int i = 0; i < results.size(); i++) {
			resultat.add((OutdoorScene) results.get(i));
		}
		em.getTransaction().commit();
		em.close();
		return resultat;
	}

	
	
}
