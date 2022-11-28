package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comentarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcomentarios;
	private String comentario;

	@ManyToOne
	@JoinColumn(name = "idalumnos")
	private Alumnos idalumnos;

	@ManyToOne
	@JoinColumn(name = "idcurso")
	private Cursos idcurso;

	public Comentarios() {
		super();
	}

	public Comentarios(int idcomentarios, String comentario, Alumnos idalumnos, Cursos idcurso) {
		super();
		this.idcomentarios = idcomentarios;
		this.comentario = comentario;
		this.idalumnos = idalumnos;
		this.idcurso = idcurso;
	}

	public int getIdcomentarios() {
		return idcomentarios;
	}

	public void setIdcomentarios(int idcomentarios) {
		this.idcomentarios = idcomentarios;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Alumnos getIdalumnos() {
		return idalumnos;
	}

	public void setIdalumnos(Alumnos idalumnos) {
		this.idalumnos = idalumnos;
	}

	public Cursos getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Cursos idcurso) {
		this.idcurso = idcurso;
	}

	@Override
	public String toString() {
		return "Comentarios [idcomentarios=" + idcomentarios + ", comentario=" + comentario + ", idalumnos=" + idalumnos
				+ ", idcurso=" + idcurso + "]";
	}

}
