package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cursos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcursos;
	private String nombre;
	private String descripcion;
	private int nivel;

	@ManyToOne
	@JoinColumn(name = "idprofesor")
	private Profesores profesor;
	private Date fechaInicio;
	private Date fechaFin;
	public Cursos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cursos(int idnoticias, String nombre, String descripcion, int nivel, Profesores profesor, Date fechaInicio,
			Date fechaFin) {
		super();
		this.idcursos = idnoticias;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.profesor = profesor;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public int getIdnoticias() {
		return idcursos;
	}
	public void setIdnoticias(int idnoticias) {
		this.idcursos = idnoticias;
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
	public Profesores getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesores profesor) {
		this.profesor = profesor;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	@Override
	public String toString() {
		return "Cursos [idnoticias=" + idcursos + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel="
				+ nivel + ", profesor=" + profesor + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	

}
