package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcomentario;

	@Size(max = 45)
	private String comentario;

	@ManyToOne
	@JoinColumn(name = "id")
	private Usuario id;

	@ManyToOne
	@JoinColumn(name = "idcurso")
	private Curso idcurso;

	public Comentario() {
		super();
	}

	public Comentario(int idcomentario, @Size(max = 45) String comentario, Usuario id, Curso idcurso) {
		super();
		this.idcomentario = idcomentario;
		this.comentario = comentario;
		this.id = id;
		this.idcurso = idcurso;
	}

	public int getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(int idcomentario) {
		this.idcomentario = idcomentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getId() {
		return id;
	}

	public void setId(Usuario id) {
		this.id = id;
	}

	public Curso getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Curso idcurso) {
		this.idcurso = idcurso;
	}

	@Override
	public String toString() {
		return "Comentario [idcomentario=" + idcomentario + ", comentario=" + comentario + ", id=" + id + ", idcurso="
				+ idcurso + "]";
	}

}
