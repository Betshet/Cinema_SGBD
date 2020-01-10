package model;

import javax.persistence.*;

@Entity
public class Clap {
	
	

	@Id
	private int id;
	private long sceneDuration;
	
	@OneToOne
	private FilmRoll roll;
	
	public Clap(int id, long sceneDuration, FilmRoll roll) {
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
	
	public FilmRoll getRoll() {
		return roll;
	}
	
	public void setRoll(FilmRoll roll) {
		this.roll = roll;
	}
	
	

}
