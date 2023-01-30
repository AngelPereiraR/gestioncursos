package com.example.demo.model;

import com.example.demo.entity.Matricula;

public class AlumnoMatriculado {
	
	private UsuarioModel usuarioModel;
	
	private Matricula matricula;
	
	private int calificacion;
	
	private int numCursos;
	
	private float notaMedia;

	public AlumnoMatriculado() {
		super();
	}

	public AlumnoMatriculado(UsuarioModel usuarioModel, Matricula matricula, int calificacion, int numCursos, float notaMedia) {
		super();
		this.usuarioModel = usuarioModel;
		this.matricula = matricula;
		this.calificacion = calificacion;
		this.numCursos = numCursos;
		this.notaMedia = notaMedia;
	}

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public int getNumCursos() {
		return numCursos;
	}

	public void setNumCursos(int numCursos) {
		this.numCursos = numCursos;
	}
	
	public float getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(float notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public String toString() {
		return "AlumnosMatriculados [usuarioModel=" + usuarioModel + ", matricula=" + matricula + "]";
	}
}
