package model;

import javax.persistence.*;

@Entity
public class Clap {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private long sceneDuration;
	
	@ManyToOne
	private FilmRoll roll;
	
	@ManyToOne
	private Setup setup;
	
	public Clap() {
		
	}
	
	public Clap(long sceneDuration, FilmRoll roll, Setup setup) {

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

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	
	

}
