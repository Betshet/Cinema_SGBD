package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class IndoorScene extends Scene {

	@OneToOne
	private Theater theater;

	public IndoorScene(int id, String desc, List<Setup> listSetup, Theater theater) {
		super(id, desc, listSetup);
		this.theater = theater;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
	
	
	
}
