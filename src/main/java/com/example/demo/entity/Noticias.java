package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Noticias {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idnoticias;
	
	private String titulo;
	
	private String descripcion;
	
	private String imagen;
	
	@ManyToOne
	@JoinColumn(name="idadministrador")
	private Administradores administradores;

	public Noticias() {
		super();
	}

	public Noticias(int idnoticias, String titulo, String descripcion, String imagen,
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
		return "Noticias [idnoticias=" + idnoticias + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", administradores=" + administradores + "]";
	}
}
