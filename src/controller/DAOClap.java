package controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Clap;
import model.Scene;

public class DAOClap {
	
	EntityManagerFactory entityManagerFactory;
	
	
	public DAOClap(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	public ArrayList<Clap> findAllClap()
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		ArrayList<Clap> resultat = new ArrayList<Clap>();
		String queryString = "select c from Clap c";
		Query query = em.createQuery(queryString);
		ArrayList<Clap> results = (ArrayList<Clap>) query.getResultList();
		
		for (int i = 0; i < results.size(); i++) {
			resultat.add((Clap) results.get(i));
		}
		em.getTransaction().commit();
		em.close();
		return resultat;
	}

}
