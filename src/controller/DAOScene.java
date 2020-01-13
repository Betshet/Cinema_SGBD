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
		String queryString = "select scene from Scene scene";
		Query query = em.createQuery(queryString);
		ArrayList<Scene> results = (ArrayList<Scene>) query.getResultList();
		
		for (int i = 0; i < results.size(); i++) {
			Scene scene = (Scene) results.get(i);
			resultat.add(scene);
		}
		em.getTransaction().commit();
		em.close();
		return resultat;
	}
	
	
	/*public static List<SceneExterieur> retrunAllSceneExterieur() {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ArrayList<SceneExterieur> resultat = new ArrayList<SceneExterieur>();
		String queryString = "select s from SceneExterieur s";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			SceneExterieur SceneExterieur = (SceneExterieur) results.get(i);
			resultat.add(SceneExterieur);
		}
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return resultat;
	};*/
	
	
	
}
