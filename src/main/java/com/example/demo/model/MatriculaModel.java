package com.example.demo.model;

import com.example.demo.entity.Alumnos;
import com.example.demo.entity.Cursos;

public class MatriculaModel {

	private int idmatricula;

	private Alumnos alumno;

	private Cursos curso;

	private int valoracion;

	public MatriculaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatriculaModel(int idmatricula, Alumnos alumno, Cursos curso, int valoracion) {
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
