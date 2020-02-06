package bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.webapp.FacesServlet;

import org.apache.geronimo.mail.util.SessionUtil;

import dao.encurtadorDAO;
import dao.usuarioDAO;
import model.Encurtador;
import model.Usuario;
import util.SessionUtils;
import util.utils;

public class LoginBean {

	public String email;
	public String password;
	public usuarioDAO UsuarioDAO       = usuarioDAO.getInstance();
	public encurtadorDAO EncurtadorDAO = encurtadorDAO.getInstance(); 
	public SessionUtils session        = SessionUtils.getInstance();
	
	public LoginBean() {
		System.out.println("INITIALIZED");
		String paramID = session.getParamId();
		if (paramID != null) {
			Encurtador e = encurtadorDAO.getInstance().getURL("http://localhost:8080/Modelo/?id="+paramID);
			if (e != null) {
				System.out.println("DIFERENTE DE NULO");
				session.redirectNow(e.getOld_url());
			}
		}
	}
	
	
	public String login() {
		
		FacesContext context = FacesContext.getCurrentInstance();	
		Usuario usuario = UsuarioDAO.login(this.email, this.password);
		if (usuario == null) {
			context.addMessage("", new FacesMessage("Atenção", "Email ou Senha inválidos!"));
		}else {
			context.addMessage("", new FacesMessage("Atenção", "Login válido!"));
			session.setUsuarioSession(usuario);
			session.setAuthenticated(true);
			return "/app/list.xhtml?face-redirect=true";
		}
		
		return "";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
