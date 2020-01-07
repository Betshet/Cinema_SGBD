package model;

public class Location {
	
	private int id;
	private String place;
	private String desc;
	
	public Location(int id, String place, String desc) {
		this.id = id;
		this.place = place;
		this.desc = desc;
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
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	
	
}
