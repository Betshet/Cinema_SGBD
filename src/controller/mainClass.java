package controller;


import view.SceneWindow;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Clap;
import model.FilmRoll;
import model.IndoorScene;
import model.Location;
import model.OutdoorScene;
import model.Scene;
import model.Setup;


public class mainClass {

	public static void main(String[] args) {


		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager em = entityManagerFactory.createEntityManager();

		FilmRoll roll = new FilmRoll(1);

		ArrayList<Clap> clapList = new ArrayList<Clap>();
		clapList.add(new Clap(1, 370, roll) );
		clapList.add(new Clap(2, 242, roll) );
		clapList.add( new Clap(3, 70, roll) );
		clapList.add(new Clap(4, 55, roll));
		clapList.add(new Clap(5, 228, roll));


		ArrayList<Clap> clapList2 = new ArrayList<Clap>();
		clapList.add(new Clap(6, 842, roll) );
		clapList.add(new Clap(7, 37, roll) );
		clapList.add( new Clap(8, 82, roll) );
		clapList.add(new Clap(9, 180, roll));
		clapList.add(new Clap(10, 372, roll));

		ArrayList<Setup> setupList = new ArrayList<Setup>();
		setupList.add(new Setup(1, "Ceci est une description", clapList));
		setupList.add(new Setup(2, "Ceci est une description : le retour", clapList2));

		Location loc = new Location(1,"Paris","la tour eiffel wesh");

		ArrayList<Scene> scList = new ArrayList<Scene>();
		scList.add( new OutdoorScene(1, "Lorem Ipsum", setupList, loc, "DAY"));

		//SceneWindow scWindow = new SceneWindow(scList);
		
		em.getTransaction().begin();
		em.persist(scList);
		em.persist(loc);
		em.persist(setupList);
		em.persist(clapList2);
		em.persist(clapList);
		em.persist(roll);
		//em.persist(scList); //pas sur
		em.getTransaction().commit();
		
		em.close();
		
		
		//scWindow.afficher();



	}

}
