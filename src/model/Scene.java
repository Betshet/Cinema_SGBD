package model;

import java.util.ArrayList;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="TYPE_SCENE")
public class Scene {

	@Id
	private int id;
	private String desc;
	
	@OneToMany
	private ArrayList<Setup> listSetup;
	
	public Scene()
	{
		id=-1;
		desc = null;
		listSetup = null;
	}
	
	public Scene(int id, String desc, ArrayList<Setup> listSetup, Location filmLocation) {
		this.id = id;
		this.desc = desc;
		this.listSetup = listSetup;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public ArrayList<Setup> getListSetup() {
		return listSetup;
	}
	
	public void setListSetup(ArrayList<Setup> listSetup) {
		this.listSetup = listSetup;
	}
	
	
	
	
}
