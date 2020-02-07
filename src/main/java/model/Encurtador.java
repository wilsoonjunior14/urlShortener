package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	private Date data;

	private boolean deleted;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;	
	
	public String validate() {
		if (new_url.length() <= 0 || new_url.length() > 255) {
			return "Nova URL está inválida! Máximo de 255 caracteres são permitidos";
		}
		if (old_url.length() <= 0 || old_url.length() > 255) {
			return "URL está inválida! Máximo de 255 caracteres são permitidos";
		}
		if (data == null) {
			return "Nova URL está inválida! Máximo de 255 caracteres são permitidos";
		}
		
		return "";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

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
