package model;

import javax.persistence.*;

@Entity
public class Clap {
	
	

	@Id
	//TODO Generation auto d'id
	private static int id = 0;
	private long sceneDuration;
	
	@ManyToOne
	private FilmRoll roll;
	
	@ManyToOne
	private Setup setup;
	
	public Clap(long sceneDuration, FilmRoll roll, Setup setup) {
		Clap.id++;
		this.sceneDuration = sceneDuration;
		this.roll = roll;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		Clap.id = id;
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

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	
	

}
