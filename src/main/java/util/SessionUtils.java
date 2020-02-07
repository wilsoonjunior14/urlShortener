package util;

import java.io.IOException;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

public class SessionUtils {

	private static SessionUtils instance;
	public static Usuario usuario = null;
	
	public static SessionUtils getInstance() {
		if (instance == null) {
			instance = new SessionUtils();
		}
		return instance;
	}
	
	public SessionUtils() {
		
	}
	
	public static boolean isAuthenticated() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Map<String, Object> session = context.getExternalContext().getSessionMap();
			System.out.println("IsAuthenticated: "+session.get("authenticated"));
			return (boolean) session.get("authenticated");
		}catch (Exception e) {
			return false;
		}
	}
	
	public static boolean setAuthenticated(boolean status) {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> session = context.getExternalContext().getSessionMap();
		session.put("authenticated", status);
		return (boolean) session.get("authenticated");
	}
	
	public static void redirect() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
			response.sendRedirect("/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void redirectNow(String url) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
			response.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String logout() {
		setAuthenticated(false);
		return "/index.xhtml";
	}
	
	public static String getParamId() {
		Map<String, String> params =FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		String ID = params.get("id");
		return ID;
	}
	
	public static void setUsuarioSession(Usuario u) {
		usuario = u;
	}
	
	
	
}
