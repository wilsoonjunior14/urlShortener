package util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.mail.internet.InternetAddress;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

public class utils {

	public static Usuario usuario = null;
	public static EntityManager entityManagerStatic = null;
	
	public static boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (Exception ex) {
		      result = false;
		   }
		   return result;
	}
	
	public static void setEntityManager(EntityManager entity) {
		entityManagerStatic = entity;
	}
	
	public static String generateString() {
		String generated = UUID.randomUUID().toString();
		if (generated.length() > 4) return generated.substring(0, 4);
		return generated;
	}
	
}
