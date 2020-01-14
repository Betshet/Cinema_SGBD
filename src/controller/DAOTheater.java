package controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Theater;

public class DAOTheater {

	EntityManagerFactory entityManagerFactory;
	
	
	public DAOTheater(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	public ArrayList<Theater> findAllTheater()
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		ArrayList<Theater> resultat = new ArrayList<Theater>();
		String queryString = "select st from Setup st";
		Query query = em.createQuery(queryString);
		ArrayList<Theater> results = (ArrayList<Theater>) query.getResultList();
		
		for (int i = 0; i < results.size(); i++) {
			resultat.add((Theater) results.get(i));
		}
		em.getTransaction().commit();
		em.close();
		return resultat;
	}
}
