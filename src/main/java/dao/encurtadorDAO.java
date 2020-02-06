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
	
	public boolean save(Usuario u, Encurtador e) {
		try {
			entityManager.getTransaction().begin();
			e.setUsuario(u);
			entityManager.persist(e);
			entityManager.getTransaction().commit();
			return true;
		}catch(Exception exc) {
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean delete(Encurtador e) {
		try {
			entityManager.getTransaction().begin();
			
			entityManager.remove(e);
			
			entityManager.getTransaction().commit();
			return true;
		}catch(Exception exc) {
			entityManager.getTransaction().rollback();
			return false;
		}
	}
	
	public ArrayList<Encurtador> getURLsUsuario(Usuario usuario){
		return (ArrayList<Encurtador>) entityManager.createQuery("SELECT e FROM Encurtador e WHERE e.usuario.id = "+usuario.getId()+"").getResultList();
	}
	
	public Encurtador getURL(String url) {
		ArrayList<Encurtador> list = (ArrayList<Encurtador>) entityManager.createQuery("SELECT e FROM Encurtador e WHERE e.new_url = '"+url+"'").getResultList();
		if (list == null) return null;
		if (list.size() == 0) return null;
		return list.get(0);
	}
	
}
