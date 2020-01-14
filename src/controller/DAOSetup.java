package controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Setup;

public class DAOSetup {

	
	EntityManagerFactory entityManagerFactory;
	
	
	public DAOSetup(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	public ArrayList<Setup> findAllSetup()
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		ArrayList<Setup> resultat = new ArrayList<Setup>();
		String queryString = "select st from Setup st";
		Query query = em.createQuery(queryString);
		ArrayList<Setup> results = (ArrayList<Setup>) query.getResultList();
		
		for (int i = 0; i < results.size(); i++) {
			resultat.add((Setup) results.get(i));
		}
		em.getTransaction().commit();
		em.close();
		return resultat;
	}
	
}
