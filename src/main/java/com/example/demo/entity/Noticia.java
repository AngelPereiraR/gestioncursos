package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idnoticia;

	@Size(max = 45)
	private String titulo;

	@Size(max = 45)
	private String descripcion;

	@Size(max = 45)
	private String imagen;

	@ManyToOne
	@JoinColumn(name = "idadministrador")
	private Usuario id;

	public Noticia() {
		super();
	}

	public Noticia(int idnoticia, @Size(max = 45) String titulo, @Size(max = 45) String descripcion,
			@Size(max = 45) String imagen, Usuario id) {
		super();
		this.idnoticia = idnoticia;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.id = id;
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

	public Usuario getIdadministrador() {
		return id;
	}

	public void setIdadministrador(Usuario id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Noticia [idnoticia=" + idnoticia + ", titulo=" + titulo + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", id=" + id + "]";
	}

}
