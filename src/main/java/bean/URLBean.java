package bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import dao.encurtadorDAO;
import model.Encurtador;
import model.Usuario;
import util.utils;

public class URLBean {

	Usuario usuario = utils.usuario;
	Encurtador url = new Encurtador();
	ArrayList<Encurtador> listURLs = new ArrayList<Encurtador>();
	encurtadorDAO EncurtadorDAO = encurtadorDAO.getInstance();
	
	boolean exibir  = false;
	String nova_url = "";

	public void adicionarURL() {
		exibir = true;
		String url_base = utils.generateString();
		
		while (EncurtadorDAO.verifyIfExists(url_base)) {
			url_base = utils.generateString();
		}
		nova_url = "http://localhost:8080/Modelo/"+url_base;
		url.setNew_url(nova_url);
		listURLs.add(url);
		url = new Encurtador();
	}
	
	public boolean isExibir() {
		return exibir;
	}



	public void setExibir(boolean exibir) {
		this.exibir = exibir;
	}



	public String getNova_url() {
		return nova_url;
	}



	public void setNova_url(String nova_url) {
		this.nova_url = nova_url;
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Encurtador getUrl() {
		return url;
	}

	public void setUrl(Encurtador url) {
		this.url = url;
	}

	public ArrayList<Encurtador> getListURLs() {
		return listURLs;
	}

	public void setListURLs(ArrayList<Encurtador> listURLs) {
		this.listURLs = listURLs;
	}
	
	
	
}
