package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import connection.HibernateConnection;
import model.Encurtador;
import model.Usuario;
import util.utils;

public class encurtadorDAO {

	private static encurtadorDAO instance;
	protected EntityManager entityManager;
	
	public static encurtadorDAO getInstance() {
		if (instance == null) {
			instance = new encurtadorDAO();
		}
		return instance;
	}
	
	private encurtadorDAO() {
		if (utils.entityManagerStatic == null) {
			entityManager = HibernateConnection.getInstance().getConnection();
			utils.setEntityManager(entityManager);
		}else {
			entityManager = utils.entityManagerStatic;
		}
	}
	
	public boolean verifyIfExists(String url) {
		try {
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) entityManager.createQuery("SELECT u FROM Usuario u").getResultList();
			
			System.out.println("Quantidade: "+usuarios.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
