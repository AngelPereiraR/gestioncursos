package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cursos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcursos;
	private String nombre;
	private String descripcion;
	private int nivel;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
	private List<Comentarios> idcomentarios;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
	private List<Comentarios> idmatriculas;

	@ManyToOne
	@JoinColumn(name = "idprofesores")
	private Profesor idprofesores;
	private Date fechaInicio;
	private Date fechaFin;

	public Cursos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cursos(int idcursos, String nombre, String descripcion, int nivel, List<Comentarios> idcomentarios,
			List<Comentarios> idmatriculas, Profesor profesor_id, Date fechaInicio, Date fechaFin) {
		super();
		this.idcursos = idcursos;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.idcomentarios = idcomentarios;
		this.idmatriculas = idmatriculas;
		this.idprofesores = profesor_id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public int getIdcursos() {
		return idcursos;
	}

	public void setIdcursos(int idcursos) {
		this.idcursos = idcursos;
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

	public List<Comentarios> getIdcomentarios() {
		return idcomentarios;
	}

	public void setIdcomentarios(List<Comentarios> idcomentarios) {
		this.idcomentarios = idcomentarios;
	}

	public List<Comentarios> getIdmatriculas() {
		return idmatriculas;
	}

	public void setIdmatriculas(List<Comentarios> idmatriculas) {
		this.idmatriculas = idmatriculas;
	}

	public Profesor getProfesor_id() {
		return idprofesores;
	}

	public void setProfesor_id(Profesor profesor_id) {
		this.idprofesores = profesor_id;
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
		return "Cursos [idcursos=" + idcursos + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel="
				+ nivel + ", idcomentarios=" + idcomentarios + ", idmatriculas=" + idmatriculas + ", profesor_id="
				+ idprofesores + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

}
