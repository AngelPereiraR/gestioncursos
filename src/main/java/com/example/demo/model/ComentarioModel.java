package com.example.demo.model;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Curso;

public class ComentarioModel {

	private int idcomentario;

	private Alumno alumno;

	private Curso curso;

	private String comentario;

	public ComentarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioModel(int idcomentario, Alumno alumno, Curso curso, String comentario) {
		super();
		this.idcomentario = idcomentario;
		this.alumno = alumno;
		this.curso = curso;
		this.comentario = comentario;
	}

	public int getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(int idcomentario) {
		this.idcomentario = idcomentario;
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
		return "ComentariosModel [idcomentario=" + idcomentario + ", alumno=" + alumno + ", curso=" + curso
				+ ", comentario=" + comentario + "]";
	}

}
