package com.example.demo.model;

import java.util.Date;

import com.example.demo.entity.Usuario;

public class CursoModel {

	private int idcurso;

	private String nombre;

	private String descripcion;

	private int nivel;

	private Usuario id;

	private String fechaInicio;

	private String fechaFin;

	public CursoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CursoModel(int idcurso, String nombre, String descripcion, int nivel, Usuario id, String fechaInicio,
			String fechaFin) {
		super();
		this.idcurso = idcurso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public int getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Usuario getIdprofesor() {
		return id;
	}

	public void setIdprofesor(Usuario id) {
		this.id = id;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "CursosModel [idcurso=" + idcurso + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel="
				+ nivel + ", usuario=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

}
