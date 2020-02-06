package bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import dao.usuarioDAO;
import model.Usuario;
import util.utils;

public class LoginBean {

	public String email;
	public String password;
	public usuarioDAO UsuarioDAO = usuarioDAO.getInstance();
	
	public String login() {
		
		FacesContext context = FacesContext.getCurrentInstance();	
		Usuario usuario = UsuarioDAO.login(this.email, this.password);
		if (usuario == null) {
			context.addMessage("", new FacesMessage("Atenção", "Email ou Senha inválidos!"));
		}else {
			context.addMessage("", new FacesMessage("Atenção", "Login válido!"));
			utils.setUsuarioSession(usuario);
			utils.setAuthenticated(true);
			return "app/list";
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
