package tests;
import dao.usuarioDAO;
import model.*;

public class connectionTest {

	public static void main(String[] args) {
		
		Usuario u = new Usuario();
		u.setEmail("wjunior_msn@hotmail.com");
		u.setPassword("12345");
		u.setName("Wilson Junior");
		
		System.out.println("Save user ?"+usuarioDAO.getInstance().add(u));
		
	}
	
}
