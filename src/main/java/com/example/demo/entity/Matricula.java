package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idmatricula;

	@ManyToOne
	@JoinColumn(name = "idalumno")
	private Alumnos alumno;

	@ManyToOne
	@JoinColumn(name = "idcurso")
	private Cursos curso;

	private int valoracion;

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matricula(int idmatricula, Alumnos alumno, Cursos curso, int valoracion) {
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
		return "Matricula [idmatricula=" + idmatricula + ", alumno=" + alumno + ", curso=" + curso + ", valoracion="
				+ valoracion + "]";
	}

}
