package model;

import java.util.ArrayList;

public class OutdoorScene extends Scene {

	private Location location;
	private long shootingTime;
	
	public OutdoorScene(int id, String desc, ArrayList<Setup> listSetup, Location filmLocation, Location location,
			long shootingTime) {
		super(id, desc, listSetup, filmLocation);
		this.location = location;
		this.shootingTime = shootingTime;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public long getShootingTime() {
		return shootingTime;
	}
	public void setShootingTime(long shootingTime) {
		this.shootingTime = shootingTime;
	}
	
	
	
	
	
	
}
