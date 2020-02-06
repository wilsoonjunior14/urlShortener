package model;

import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Table;

import java.util.*;

import util.utils;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 255, nullable = false)
	private String name;
	
	@Column(length = 255, unique = true, nullable = false)
	private String email;
	
	@Column(length = 255)
	private String password;
	
	public String validate() {
		if (this.name.length() <= 0 || this.name.length() > 255) {
			return "Nome inválido! Máximo de 255 caracteres são permitidos!";
		}
		
		if (this.email.length() <= 0 || this.email.length() > 255 || !utils.isValidEmailAddress(this.email)) {
			return "Email está inválido! Máximo de 255 caracteres são permitidos";
		}
		
		if (this.password.length() <= 0 || this.password.length() > 255) {
			return "Senha inválida! Máximo de 255 caracteres são permitidos";
		}
		
		return "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
