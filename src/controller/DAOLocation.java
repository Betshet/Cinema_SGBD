package controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Location;
import model.Theater;

public class DAOLocation {
	
	EntityManagerFactory entityManagerFactory;
	
	
	public DAOLocation(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	public ArrayList<Location> findAllLocation()
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		ArrayList<Location> resultat = new ArrayList<Location>();
		String queryString = "select l from Location l";
		Query query = em.createQuery(queryString);
		ArrayList<Location> results = (ArrayList<Location>) query.getResultList();
		
		for (int i = 0; i < results.size(); i++) {
			resultat.add((Location) results.get(i));
		}
		em.getTransaction().commit();
		em.close();
		return resultat;
	}
	
	

}
