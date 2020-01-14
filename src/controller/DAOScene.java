package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import model.Scene;

public class DAOScene {

	EntityManagerFactory entityManagerFactory;
	
	
	public DAOScene(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	public ArrayList<Scene> findAllScene()
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		ArrayList<Scene> resultat = new ArrayList<Scene>();
		String queryString = "select s from Scene s";
		Query query = em.createQuery(queryString);
		ArrayList<Scene> results = (ArrayList<Scene>) query.getResultList();
		
		for (int i = 0; i < results.size(); i++) {
			resultat.add((Scene) results.get(i));
		}
		em.getTransaction().commit();
		em.close();
		return resultat;
	}
	
	
	
}
