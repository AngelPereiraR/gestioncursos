package com.example.demo.model;

import com.example.demo.entity.Usuario;

public class NoticiaModel {

	private int idnoticia;

	private String titulo;

	private String descripcion;

	private String imagen;
	
	private String fechaCreacion;

	private Usuario usuario;

	public NoticiaModel() {
		super();
	}

	public NoticiaModel(int idnoticia, String titulo, String descripcion, String imagen, String fechaCreacion, Usuario usuario) {
		super();
		this.idnoticia = idnoticia;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.fechaCreacion = fechaCreacion;
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

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "NoticiaModel [idnoticia=" + idnoticia + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", fechaCreacion=" + fechaCreacion + ", usuario=" + usuario + "]";
	}
}
