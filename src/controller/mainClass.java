package controller;


import view.SceneWindow;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.IndoorScene;
import model.Location;
import model.OutdoorScene;
import model.Scene;


public class mainClass {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager em = entityManagerFactory.createEntityManager();

		
		
	}

}
