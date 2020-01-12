package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_SCENE")
public class Scene {

	@Id
	private int id;
	private String sceneDescription;
	
	@OneToMany
	private List<Setup> listSetup;
	
	public Scene()
	{
		id=-1;
		sceneDescription = null;
		listSetup = null;
	}
	
	public Scene(int id, String desc, List<Setup> listSetup) {
		this.id = id;
		this.sceneDescription = desc;
		this.listSetup = listSetup;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDesc() {
		return sceneDescription;
	}
	
	public void setDesc(String desc) {
		this.sceneDescription = desc;
	}
	
	public List<Setup> getListSetup() {
		return listSetup;
	}
	
	public void setListSetup(List<Setup> listSetup) {
		this.listSetup = listSetup;
	}
	
	
	
	
}
