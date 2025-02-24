package model;

import java.util.List;
import javax.persistence.Entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_SCENE")
public class Scene {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String sceneDescription;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Setup> listSetup;
	
	public Scene()
	{
	}
	
	public Scene(String desc, List<Setup> listSetup) {
		
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
