package model;

public class Clap {
	
	private int id;
	private long sceneDuration;
	private Roll roll;
	
	public Clap(int id, long sceneDuration, Roll roll) {
		this.id = id;
		this.sceneDuration = sceneDuration;
		this.roll = roll;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public long getSceneDuration() {
		return sceneDuration;
	}
	
	public void setSceneDuration(long sceneDuration) {
		this.sceneDuration = sceneDuration;
	}
	
	public Roll getRoll() {
		return roll;
	}
	
	public void setRoll(Roll roll) {
		this.roll = roll;
	}
	
	

}
