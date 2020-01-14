package controller;


import view.ClapWindow;
import view.SceneWindow;
import view.SetupWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		List<Scene> scList = new ArrayList<Scene>();
		
		Location loc = new Location(1,"Paris","Tour eiffel");
		OutdoorScene sc = new OutdoorScene("lorem ipsum",null, loc, "DAY");
		FilmRoll roll = new FilmRoll();
		PopulateScene(sc,roll);
		
		scList.add(sc);

		em.getTransaction().begin();
		em.persist(loc);
		em.persist(roll);
		for(Setup st : sc.getListSetup())
		{
			em.persist(st);
			for(Clap cl : st.getListClaps())
			{
				em.persist(cl);
			}
		}
		
		for(Scene current : scList)
		{
			em.persist(current);
		}
		em.getTransaction().commit();
		
		em.close();
		
		controlWindow control = new controlWindow(factory);
		control.launchSceneWindow();

	}
	
	public static void PopulateScene(Scene sc, FilmRoll roll) {
		sc.setListSetup(GenerateSetup(sc,3,roll));
		
	}
	
	public static List<Setup> GenerateSetup(Scene sc, int nb,FilmRoll roll) {
		List<Setup> res = new ArrayList<Setup>();
		for(int i = 0; i<nb; i++) {
			Setup st = new Setup("Auto generated setup n°"+sc.getId()+"-"+i,null,sc);
			st.setListClaps(GenerateClap(st,5,roll));
			res.add(st);
			
		}
		return res;
	}
	
	public static List<Clap> GenerateClap(Setup st, int nb,FilmRoll roll){
		List<Clap> res = new ArrayList<Clap>();
		Random rand = new Random();
		for(int i = 0; i<nb; i++) {
			res.add(new Clap(rand.nextInt(1000),roll,st));
		}
		return res;
		
	}

}
