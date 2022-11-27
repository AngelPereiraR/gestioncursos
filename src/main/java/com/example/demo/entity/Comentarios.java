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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcomentarios;
	private int idAlumno;
	private int idCurso;
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name="idAlumno")
	private Alumnos alumno;

	public Comentarios() {
		super();
	}

	public Comentarios(int idComentarios, int idAlumno, int idCurso, String comentario, Alumnos alumno) {
		super();
		this.idcomentarios = idComentarios;
		this.idAlumno = idAlumno;
		this.idCurso = idCurso;
		this.comentario = comentario;
		this.alumno = alumno;
	}

	public int getIdComentarios() {
		return idcomentarios;
	}

	public void setIdComentarios(int idComentarios) {
		this.idcomentarios = idComentarios;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Alumnos getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "Comentarios [idComentarios=" + idcomentarios + ", idAlumno=" + idAlumno + ", idCurso=" + idCurso
				+ ", comentario=" + comentario + ", alumno=" + alumno + "]";
	}

}
