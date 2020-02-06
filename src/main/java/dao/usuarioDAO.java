package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import antlr.collections.List;
import connection.HibernateConnection;
import model.Encurtador;
import model.Usuario;
import util.utils;

public class usuarioDAO {

	private static usuarioDAO instance;
	protected EntityManager entityManager;
	
	public static usuarioDAO getInstance() {
		if (instance == null) {
			instance = new usuarioDAO();
		}
		return instance;
	}
	
	private usuarioDAO() {
		if (utils.entityManagerStatic == null) {
			entityManager = HibernateConnection.getInstance().getConnection();
			utils.setEntityManager(entityManager);
		}else {
			entityManager = utils.entityManagerStatic;
		}
	}
	
	public boolean add(Usuario u){
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(u);
			entityManager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public Usuario login(String email, String password) {
		try {
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = '"+email+"' AND u.password = '"+password+"'").getResultList();
			
			return usuarios.get(0);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
