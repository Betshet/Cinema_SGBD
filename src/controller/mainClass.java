package controller;


import view.SceneWindow;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class mainClass {

	public static void main(String[] args) {
		SceneWindow window = new SceneWindow();
		window.afficher();

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		//Cr�ation des objets
		
		
		//Instructions � la bdd;
		em.getTransaction().begin();
		//em.persist(OBJET);
		em.getTransaction().commit();
		
		//pour trouver
		//Student test = (Student) em.find(Student.class, "debile@idiot.com");
		
		em.close();

	}

}
