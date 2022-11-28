package com.example.demo.model;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Curso;

public class ComentariosModel {

	private int idcomentarios;

	private Alumno alumno;

	private Curso curso;

	private String comentario;

	public ComentariosModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentariosModel(int idcomentarios, Alumno alumno, Curso curso, String comentario) {
		super();
		this.idcomentarios = idcomentarios;
		this.alumno = alumno;
		this.curso = curso;
		this.comentario = comentario;
	}

	public int getIdcomentarios() {
		return idcomentarios;
	}

	public void setIdcomentarios(int idcomentarios) {
		this.idcomentarios = idcomentarios;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "ComentariosModel [idcomentarios=" + idcomentarios + ", alumno=" + alumno + ", curso=" + curso
				+ ", comentario=" + comentario + "]";
	}

}
