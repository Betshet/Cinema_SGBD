package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FilmRoll {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 
	
	public FilmRoll() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
