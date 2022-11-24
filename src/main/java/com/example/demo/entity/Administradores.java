package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Administradores {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idadministradores;
	
	private String usuario;
	
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="administradores")
	private List<Noticias> noticias;
	
	public Administradores(int idadministradores, String usuario, String password, List<Noticias> noticias) {
		super();
		this.idadministradores = idadministradores;
		this.usuario = usuario;
		this.password = password;
		this.noticias = noticias;
	}
	
	public Administradores() {
		super();
	}

	public int getIdadministradores() {
		return idadministradores;
	}

	public void setIdadministradores(int idadministradores) {
		this.idadministradores = idadministradores;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Noticias> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticias> noticias) {
		this.noticias = noticias;
	}

	@Override
	public String toString() {
		return "Administradores [idadministradores=" + idadministradores + ", usuario=" + usuario + ", password="
				+ password + ", noticias=" + noticias + "]";
	}

}
