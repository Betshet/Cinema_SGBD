package controller;


import view.ClapWindow;
import view.SceneWindow;
import view.SetupWindow;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.SessionFactory;

import model.Clap;
import model.FilmRoll;
import model.IndoorScene;
import model.Location;
import model.OutdoorScene;
import model.Scene;
import model.Setup;


public class mainClass {

	public static void main(String[] args) {


		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager em = factory.createEntityManager();

		FilmRoll roll = new FilmRoll(1);

		List<Clap> clapList = new ArrayList<Clap>();
		clapList.add(new Clap(1, 370, roll) );
		clapList.add(new Clap(2, 242, roll) );
		clapList.add( new Clap(3, 70, roll) );
		clapList.add(new Clap(4, 55, roll));
		clapList.add(new Clap(5, 228, roll));


		List<Clap> clapList2 = new ArrayList<Clap>();
		clapList.add(new Clap(6, 842, roll) );
		clapList.add(new Clap(7, 37, roll) );
		clapList.add( new Clap(8, 82, roll) );
		clapList.add(new Clap(9, 180, roll));
		clapList.add(new Clap(10, 372, roll));

		List<Setup> setupList = new ArrayList<Setup>();
		setupList.add(new Setup(1, "Ceci est une description", clapList));
		setupList.add(new Setup(2, "Ceci est une description : le retour", clapList2));

		Location loc = new Location(1,"Paris","la tour eiffel wesh");


		List<Scene> scList = new ArrayList<Scene>();
		scList.add( new OutdoorScene(1, "Lorem Ipsum", setupList, loc, "DAY"));

		

		em.getTransaction().begin();
		em.persist(loc);
		em.persist(roll);
		for(Clap current : clapList)
		{
			em.persist(current);
		}
		for(Setup current : setupList)
		{
			em.persist(current);
		}
		for(Scene current : scList)
		{
			em.persist(current);
		}
		em.getTransaction().commit();

		/*Scene temp = em.find(Scene.class, 1);
		System.out.println(temp.getDesc()+" "+temp.getId());*/
		
		
		em.close();

		/*DAOSetup test=new DAOSetup(factory);
		ArrayList<Setup> buffer = test.findAllSetup();
		for(Setup current : buffer)
		{
			System.out.println(current.getId());
		}*/
		

		
		controlWindow control = new controlWindow(factory);
		control.launchSceneWindow();
		/*SceneWindow scW = new SceneWindow(scList);
		scW.afficher();
		SetupWindow stW = new SetupWindow(setupList);
		stW.afficher();
		ClapWindow clW = new ClapWindow(clapList);
		clW.afficher();*/



	}

}
