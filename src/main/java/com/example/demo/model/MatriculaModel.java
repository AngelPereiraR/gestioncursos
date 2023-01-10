package com.example.demo.model;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Usuario;

public class MatriculaModel {

	private int idmatricula;

	private Usuario id;

	private Curso idcurso;

	private int valoracion;

	public MatriculaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatriculaModel(int idmatricula, Usuario id, Curso idcurso, int valoracion) {
		super();
		this.idmatricula = idmatricula;
		this.id = id;
		this.idcurso = idcurso;
		this.valoracion = valoracion;
	}

	public int getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}

	public Usuario getId() {
		return id;
	}

	public void setId(Usuario id) {
		this.id = id;
	}

	public Curso getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Curso idcurso) {
		this.idcurso = idcurso;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "MatriculaModel [idmatricula=" + idmatricula + ", id=" + id + ", idcurso=" + idcurso + ", valoracion="
				+ valoracion + "]";
	}

}
