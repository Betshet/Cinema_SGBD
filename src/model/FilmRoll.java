package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FilmRoll {

@Id
private static int id;

 
	
	public FilmRoll() {
		FilmRoll.id++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
