package controller;

import model.Scene;
import view.SceneWindow;

public class control {
	
	public control() {

	}
	
	public void launchSceneWindow() {
		//Aller chercher liste des scenes dans la bdd
		SceneWindow sceneWindow = new SceneWindow(null);
		sceneWindow.afficher();
	}
	
	public void launchSetupWindow(int sceneID) {
		//Aller chercher liste des setup dans la bdd
		SetupWindow setupWindow = new SetupWindow();
	}
}
