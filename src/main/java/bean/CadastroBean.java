package bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import dao.usuarioDAO;
import model.Usuario;

public class CadastroBean{
	
	public Usuario usuario = new Usuario();
	public usuarioDAO UsuarioDAO = usuarioDAO.getInstance();
	
	public String salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		// informações do usuário não estão válidas
		String validate = this.usuario.validate();
		if (!validate.equals("")) {
			context.addMessage(null, new FacesMessage("Atenção!", validate));
		}else {
			boolean saved = this.UsuarioDAO.add(this.usuario);
			if (saved) {
				context.addMessage(null, new FacesMessage("Atenção!", "Usuário salvo com sucesso!"));
				return "index";
			}
			if (!saved) {
				context.addMessage(null, new FacesMessage("Atenção!", "Não foi possível salvar usuário!"));
			}
		}
		
		return "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}