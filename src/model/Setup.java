package model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Setup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String setupDescription;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Clap> listClaps;
	
	@ManyToOne
	private Scene sc;	
	
	public Setup() {
	
	}
	
	public Setup(String desc, List<Clap> listClaps, Scene sc) {
		
		this.setupDescription = desc;
		this.listClaps = listClaps;
		this.sc = sc;
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
	public Scene getSc() {
		return sc;
	}
	public void setSc(Scene sc) {
		this.sc = sc;
	}
	
	
	
}
