package com.example.demo.model;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Usuario;

public class MatriculaModel {

	private int idmatricula;

	private Usuario user;

	private Curso curso;

	private int valoracion;

	public MatriculaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatriculaModel(int idmatricula, Usuario user, Curso curso, int valoracion) {
		super();
		this.idmatricula = idmatricula;
		this.user = user;
		this.curso = curso;
		this.valoracion = valoracion;
	}

	public int getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}

	public Usuario getAlumno() {
		return user;
	}

	public void setAlumno(Usuario user) {
		this.user = user;
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
		return "MatriculaModel [idmatricula=" + idmatricula + ", usuario=" + user + ", curso=" + curso + ", valoracion="
				+ valoracion + "]";
	}

}
