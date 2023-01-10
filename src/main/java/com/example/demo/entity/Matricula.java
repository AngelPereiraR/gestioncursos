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
	@JoinColumn(name = "id")
	private Usuario id;

	@ManyToOne
	@JoinColumn(name = "idcurso")
	private Curso idcurso;

	private int valoracion;

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matricula(int idmatricula, Usuario id, Curso idcurso, int valoracion) {
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
		return "Matricula [idmatricula=" + idmatricula + ", id=" + id + ", idcurso=" + idcurso + ", valoracion="
				+ valoracion + "]";
	}
}
