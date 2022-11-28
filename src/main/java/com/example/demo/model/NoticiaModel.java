package com.example.demo.model;

import com.example.demo.entity.Administrador;

public class NoticiaModel {

	private int idnoticia;

	private String titulo;

	private String descripcion;

	private String imagen;

	private Administrador administrador;

	public NoticiaModel() {
		super();
	}

	public NoticiaModel(int idnoticia, String titulo, String descripcion, String imagen, Administrador administrador) {
		super();
		this.idnoticia = idnoticia;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.administrador = administrador;
	}

	public int getIdnoticia() {
		return idnoticia;
	}

	public void setIdnoticia(int idnoticia) {
		this.idnoticia = idnoticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	@Override
	public String toString() {
		return "NoticiasModel [idnoticia=" + idnoticia + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", administrador=" + administrador + "]";
	}
}
