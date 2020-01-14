package model;

import java.util.List;

import javax.persistence.*;


@Entity
public class OutdoorScene extends Scene {

	@OneToOne
	@JoinColumn(name="LOCATION_ID")
	private Location location;
	private String shootingHour;
	
	public OutdoorScene( String desc, List<Setup> listSetup, Location location, String shootingHour) {
		super(desc, listSetup);
		try {		
			this.location = location;
			this.shootingHour = shootingHour;
			if(!shootingHour.equals("DAWN")&!shootingHour.equals("DAY")&!shootingHour.equals("DUSK")&!shootingHour.equals("NIGHT"))
			{
				throw new IllegalArgumentException();
			}
		}		
		catch(IllegalArgumentException i)
		{
			System.out.println("Wrong shootingHour ! Choose between DAWN, DAY, DUSK or NIGHT.");
		}
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getShootingTime() {
		return shootingHour;
	}
	public void setShootingTime(String shootingHour) {
		this.shootingHour = shootingHour;
	}
	
	
	
	
	
	
}
