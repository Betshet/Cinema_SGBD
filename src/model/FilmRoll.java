package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FilmRoll {

@Id
private int id;
	
public FilmRoll() {
	this.id = -1;
}

	public FilmRoll(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
