package model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Setup {

	@Id
	private int id;
	private String desc;
	
	@OneToMany
	private ArrayList<Clap> listClaps;
	
	
	public Setup(int id, String desc, ArrayList<Clap> listClaps) {
		super();
		this.id = id;
		this.desc = desc;
		this.listClaps = listClaps;
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
	public ArrayList<Clap> getListClaps() {
		return listClaps;
	}
	public void setListClaps(ArrayList<Clap> listClaps) {
		this.listClaps = listClaps;
	}
	
	
	
}
