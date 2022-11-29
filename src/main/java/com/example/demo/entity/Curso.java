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
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcurso;
	private String nombre;
	private String descripcion;
	private int nivel;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
	private List<Comentario> idcomentario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
	private List<Comentario> idmatricula;

	@ManyToOne
	@JoinColumn(name = "idprofesores")
	private Profesor idprofesor;
	private Date fechaInicio;
	private Date fechaFin;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(int idcurso, String nombre, String descripcion, int nivel, List<Comentario> idcomentario,
			List<Comentario> idmatricula, Profesor idprofesor, Date fechaInicio, Date fechaFin) {
		super();
		this.idcurso = idcurso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.idcomentario = idcomentario;
		this.idmatricula = idmatricula;
		this.idprofesor = idprofesor;
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

	public List<Comentario> getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(List<Comentario> idcomentario) {
		this.idcomentario = idcomentario;
	}

	public List<Comentario> getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(List<Comentario> idmatricula) {
		this.idmatricula = idmatricula;
	}

	public Profesor getIdprofesor() {
		return idprofesor;
	}

	public void setIdprofesor(Profesor idprofesor) {
		this.idprofesor = idprofesor;
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
		return "Curso [idcurso=" + idcurso + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel=" + nivel
				+ ", idcomentario=" + idcomentario + ", idmatricula=" + idmatricula + ", idprofesor=" + idprofesor
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
}