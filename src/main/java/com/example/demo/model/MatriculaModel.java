package com.example.demo.model;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Curso;

public class MatriculaModel {

	private int idmatricula;

	private Alumno alumno;

	private Curso curso;

	private int valoracion;

	public MatriculaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatriculaModel(int idmatricula, Alumno alumno, Curso curso, int valoracion) {
		super();
		this.idmatricula = idmatricula;
		this.alumno = alumno;
		this.curso = curso;
		this.valoracion = valoracion;
	}

	public int getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
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

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "MatriculaModel [idmatricula=" + idmatricula + ", alumno=" + alumno + ", curso=" + curso
				+ ", valoracion=" + valoracion + "]";
	}

}
