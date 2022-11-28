package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Noticia;

public class AdministradorModel {

	private int idadministrador;

	private String usuario;

	private String password;

	private List<Noticia> idnoticia;

	public AdministradorModel() {
		super();
	}

	public AdministradorModel(int idadministrador, String usuario, String password, List<Noticia> idnoticia) {
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
		return "AdministradorModel [idadministrador=" + idadministrador + ", usuario=" + usuario + ", password="
				+ password + ", idnoticia=" + idnoticia + "]";
	}

}
