package com.example.demo.model;

import com.example.demo.entity.Administradores;

public class NoticiasModel {
	
	private int idnoticias;
	
	private String titulo;
	
	private String descripcion;
	
	private String imagen;
	
	private Administradores administradores;

	public NoticiasModel() {
		super();
	}

	public NoticiasModel(int idnoticias, String titulo, String descripcion, String imagen,
			Administradores administradores) {
		super();
		this.idnoticias = idnoticias;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.administradores = administradores;
	}

	public int getIdnoticias() {
		return idnoticias;
	}

	public void setIdnoticias(int idnoticias) {
		this.idnoticias = idnoticias;
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

	public Administradores getAdministradores() {
		return administradores;
	}

	public void setAdministradores(Administradores administradores) {
		this.administradores = administradores;
	}

	@Override
	public String toString() {
		return "NoticiasModel [idnoticias=" + idnoticias + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", administradores=" + administradores + "]";
	}
}
