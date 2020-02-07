package bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import dao.encurtadorDAO;
import dao.usuarioDAO;
import model.Encurtador;
import model.Usuario;
import util.SessionUtils;
import util.utils;

public class URLBean {

	Usuario usuario 				= SessionUtils.usuario;
	Encurtador url 					= new Encurtador();
	ArrayList<Encurtador> listURLs  = new ArrayList<Encurtador>();
	encurtadorDAO EncurtadorDAO 	= encurtadorDAO.getInstance();
	usuarioDAO UsuarioDAO       	= usuarioDAO.getInstance();
	SessionUtils session            = SessionUtils.getInstance();
	FacesContext context 			= FacesContext.getCurrentInstance();
	
	boolean exibir  = false;
	String nova_url = "";
	
	public URLBean() {
		if (!session.isAuthenticated()) {
			session.redirect();
		}else {
			System.out.println("IS AUTHENTICATED: "+session.isAuthenticated());
			this.listURLs = EncurtadorDAO.getURLsUsuario(usuario);
		}
	}

	public void adicionarURL() {		
		FacesContext context = FacesContext.getCurrentInstance();
		String url_base = utils.generateString();
		
		while (EncurtadorDAO.verifyIfExists(url_base)) {
			url_base = utils.generateString();
		}
		nova_url = "http://localhost:8080/Modelo/?id="+url_base;
		url.setNew_url(nova_url);
		url.setData(Calendar.getInstance().getTime());
		
		String message = url.validate();
		if (message.equals("")) {
			System.out.println("USUARIO ID "+usuario.getId());
			if (EncurtadorDAO.save(usuario, url)) {
				System.out.println("URL Saved");
				listURLs.add(url);
			}else {
				System.out.println("URL not saved");
			}
			url = new Encurtador();
			context.addMessage("", new FacesMessage("Atenção!", "URL salva com sucesso!"));
		}else {
			context.addMessage("", new FacesMessage("Atenção!", message));
		}
	}
	
	public void removeURL(Encurtador e) {
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("URL "+e.getId());
		if (EncurtadorDAO.delete(e)) {
			context.addMessage("", new FacesMessage("Atenção", "URL Removida"));
			listURLs = EncurtadorDAO.getURLsUsuario(usuario);
		}else {
			context.addMessage("", new FacesMessage("Atenção", "Erro ao remover URL"));
		}
	}
	
	public String logout() {
		return SessionUtils.logout();
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
