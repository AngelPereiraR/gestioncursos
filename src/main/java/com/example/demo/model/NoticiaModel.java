package com.example.demo.model;

import com.example.demo.entity.Usuario;

public class NoticiaModel {

	private int idnoticia;

	private String titulo;

	private String descripcion;

	private String imagen;

	private Usuario usuario;

	public NoticiaModel() {
		super();
	}

	public NoticiaModel(int idnoticia, String titulo, String descripcion, String imagen, Usuario usuario) {
		super();
		this.idnoticia = idnoticia;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "NoticiasModel [idnoticia=" + idnoticia + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", usuario=" + usuario + "]";
	}
}
