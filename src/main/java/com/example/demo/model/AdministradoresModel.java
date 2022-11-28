package com.example.demo.model;

import java.util.Arrays;

import com.example.demo.entity.Noticia;

public class AdministradoresModel {
	
	private int idadministradores;
	
	private String usuario;
	
	private String password;
	
	private Noticia[] noticias;
	
	public AdministradoresModel(int idadministradores, String usuario, String password, Noticia[] noticias) {
		super();
		this.idadministradores = idadministradores;
		this.usuario = usuario;
		this.password = password;
		this.noticias = noticias;
	}
	
	public AdministradoresModel() {
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
	
	public Noticia[] getNoticias() {
		return noticias;
	}

	public void setNoticias(Noticia[] noticias) {
		this.noticias = noticias;
	}

	@Override
	public String toString() {
		return "AdministradoresModel [idadministradores=" + idadministradores + ", usuario=" + usuario + ", password="
				+ password + ", noticias=" + Arrays.toString(noticias) + "]";
	}

}
