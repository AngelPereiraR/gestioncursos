package com.example.demo.model;

import com.example.demo.entity.Alumnos;
import com.example.demo.entity.Cursos;

public class ComentariosModel {

	private int idcomentarios;

	private Alumnos alumno;

	private Cursos curso;

	private String comentario;

	public ComentariosModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentariosModel(int idcomentarios, Alumnos alumno, Cursos curso, String comentario) {
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

	public Alumnos getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
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
