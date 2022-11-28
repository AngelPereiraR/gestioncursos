package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idadministrador;

	private String usuario;

	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idadministrador")
	private List<Noticia> idnoticia;

	public Administrador() {
		super();
	}

	public Administrador(int idadministrador, String usuario, String password, List<Noticia> idnoticia) {
		super();
		this.idadministrador = idadministrador;
		this.usuario = usuario;
		this.password = password;
		this.idnoticia = idnoticia;
	}

	public int getIdadministrador() {
		return idadministrador;
	}

	public void setIdadministrador(int idadministrador) {
		this.idadministrador = idadministrador;
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

	public List<Noticia> getIdnoticia() {
		return idnoticia;
	}

	public void setIdnoticia(List<Noticia> idnoticia) {
		this.idnoticia = idnoticia;
	}

	@Override
	public String toString() {
		return "Administrador [idadministrador=" + idadministrador + ", usuario=" + usuario + ", password=" + password
				+ ", idnoticia=" + idnoticia + "]";
	}

}
