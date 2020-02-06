package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "encurtador")
public class Encurtador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String new_url;
	
	private String old_url;

	private boolean deleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNew_url() {
		return new_url;
	}

	public void setNew_url(String new_url) {
		this.new_url = new_url;
	}

	public String getOld_url() {
		return old_url;
	}

	public void setOld_url(String old_url) {
		this.old_url = old_url;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
