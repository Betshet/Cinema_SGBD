package model;
import javax.persistence.*;


@Entity
public class Theater {

	@Id
	int id;
	
	public Theater(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
