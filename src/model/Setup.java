package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Setup {

	@Id
	private int id;
	private String setupDescription;
	
	@OneToMany
	private List<Clap> listClaps;
	
	
	public Setup(int id, String desc, List<Clap> listClaps) {
		super();
		this.id = id;
		this.setupDescription = desc;
		this.listClaps = listClaps;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return setupDescription;
	}
	public void setDesc(String desc) {
		this.setupDescription = desc;
	}
	public List<Clap> getListClaps() {
		return listClaps;
	}
	public void setListClaps(List<Clap> listClaps) {
		this.listClaps = listClaps;
	}
	
	
	
}
