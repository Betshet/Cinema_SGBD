package model;
import javax.persistence.*;


@Entity
public class Location {
	
	@Id
	private int id;
	private String place;
	private String placeDescription;
	
	public Location(int id, String place, String desc) {
		this.id = id;
		this.place = place;
		this.placeDescription = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDesc() {
		return placeDescription;
	}

	public void setDesc(String desc) {
		this.placeDescription = desc;
	}

	
	
	
}
