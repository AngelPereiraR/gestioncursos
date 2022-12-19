package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcurso;

	@Size(max = 45)
	private String nombre;

	@Size(max = 45)
	private String descripcion;

	private int nivel;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
	private List<Comentario> idcomentario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
	private List<Matricula> idmatricula;

	@ManyToOne
	@JoinColumn(name = "id")
	private Usuario idprofesor;

	private String fechaInicio;

	private String fechaFin;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(int idcurso, @Size(max = 45) String nombre, @Size(max = 45) String descripcion, int nivel,
			List<Comentario> idcomentario, List<Matricula> idmatricula, Usuario id, String fechaInicio,
			String fechaFin) {
		super();
		this.idcurso = idcurso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.idcomentario = idcomentario;
		this.idmatricula = idmatricula;
		this.idprofesor = id;
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

	public List<Matricula> getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(List<Matricula> idmatricula) {
		this.idmatricula = idmatricula;
	}

	public Usuario getIdprofesor() {
		return idprofesor;
	}

	public void setIdprofesor(Usuario id) {
		this.idprofesor = id;
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
		return "Curso [idcurso=" + idcurso + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel=" + nivel
				+ ", idcomentario=" + idcomentario + ", idmatricula=" + idmatricula + ", id=" + idprofesor + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
}
