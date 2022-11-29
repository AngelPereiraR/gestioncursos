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
	@JoinColumn(name = "idalumno")
	private Alumno idalumno;

	@ManyToOne
	@JoinColumn(name = "idcurso")
	private Curso idcurso;

	public Comentario() {
		super();
	}

	public Comentario(int idcomentario, @Size(max = 45) String comentario, Alumno idalumno, Curso idcurso) {
		super();
		this.idcomentario = idcomentario;
		this.comentario = comentario;
		this.idalumno = idalumno;
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

	public Alumno getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(Alumno idalumno) {
		this.idalumno = idalumno;
	}

	public Curso getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Curso idcurso) {
		this.idcurso = idcurso;
	}

	@Override
	public String toString() {
		return "Comentario [idcomentario=" + idcomentario + ", comentario=" + comentario + ", idalumno=" + idalumno
				+ ", idcurso=" + idcurso + "]";
	}

}
