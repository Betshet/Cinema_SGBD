package model;

import java.util.ArrayList;

public class Scene {

	private int id;
	private String desc;
	private ArrayList<Setup> listSetup;
	private Location filmLocation;
	
	public Scene(int id, String desc, ArrayList<Setup> listSetup, Location filmLocation) {
		this.id = id;
		this.desc = desc;
		this.listSetup = listSetup;
		this.filmLocation = filmLocation;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public ArrayList<Setup> getListSetup() {
		return listSetup;
	}
	
	public void setListSetup(ArrayList<Setup> listSetup) {
		this.listSetup = listSetup;
	}
	
	public Location getFilmLocation() {
		return filmLocation;
	}
	
	public void setFilmLocation(Location filmLocation) {
		this.filmLocation = filmLocation;
	}
	
	
	
}
