package model;

import java.util.ArrayList;

public class IndoorScene extends Scene {

	private Theater theater;

	public IndoorScene(int id, String desc, ArrayList<Setup> listSetup, Location filmLocation, Theater theater) {
		super(id, desc, listSetup, filmLocation);
		this.theater = theater;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
	
	
	
}
