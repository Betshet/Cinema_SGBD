package controller;

import model.Scene;
import view.ClapWindow;
import view.SceneWindow;
import view.SetupWindow;

public class controlWindow {
	
	public controlWindow() {

	}
	
	public void launchSceneWindow() {
		//Aller chercher liste des scenes dans la bdd
		SceneWindow sceneWindow = new SceneWindow(null /*Passer ArrayList<Scene> en param*/);
		sceneWindow.afficher();
	}
	
	public void launchSetupWindow(int sceneID) {
		//Aller chercher liste des setup dans la bdd
		SetupWindow setupWindow = new SetupWindow(null /*Passer ArrayList<Setup> en param*/);
		setupWindow.afficher();
	}
	
	public void launchClapWindow(int setupID) {
		//Aller chercher liste des clap dans la bdd
		ClapWindow clapWindow = new ClapWindow(null /*Passer ArrayList<Clap> en param*/);
		clapWindow.afficher();
	}
}
