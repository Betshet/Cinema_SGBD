package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class mainClass {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		//Création des objets
		
		
		//Instructions à la bdd;
		em.getTransaction().begin();
		//em.persist(OBJET);
		em.getTransaction().commit();
		
		//pour trouver
		//Student test = (Student) em.find(Student.class, "debile@idiot.com");
		
		em.close();

	}

}
