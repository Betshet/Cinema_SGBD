package controller;

import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;

import model.Clap;
import model.Scene;
import model.Setup;
import view.ClapWindow;
import view.SceneWindow;
import view.SetupWindow;

public class controlWindow {
	
	private EntityManagerFactory entityManagerFactory;
	
	public controlWindow() {
		
	}
	
	public controlWindow(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public void launchSceneWindow() {
		//Aller chercher liste des scenes dans la bdd
		DAOScene control=new DAOScene(entityManagerFactory);
		ArrayList<Scene> buffer = control.findAllScene();
		
		SceneWindow sceneWindow = new SceneWindow(buffer);
		sceneWindow.afficher();
	}
	
	public void launchSetupWindow(int sceneID) {
		//Aller chercher liste des setup dans la bdd
		DAOSetup control=new DAOSetup(entityManagerFactory);
		ArrayList<Setup> buffer = control.findAllSetup();
		
		SetupWindow setupWindow = new SetupWindow(buffer);
		setupWindow.afficher();
	}
	
	public void launchClapWindow(int setupID) {
		//Aller chercher liste des clap dans la bdd
		DAOClap control=new DAOClap(entityManagerFactory);
		ArrayList<Clap> buffer = control.findAllClap();
		
		ClapWindow clapWindow = new ClapWindow(buffer);
		clapWindow.afficher();
	}
}
