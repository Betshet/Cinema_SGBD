package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class IndoorScene extends Scene {

	@OneToOne
	@JoinColumn(name="THEATER_ID")
	private Theater theater;

	public IndoorScene(String desc, List<Setup> listSetup, Theater theater) {
		super(desc, listSetup);
		this.theater = theater;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
	
	
	
}
