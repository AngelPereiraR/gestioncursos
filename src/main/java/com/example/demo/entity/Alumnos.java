package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alumnos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idalumnos;
	private String nombre;
	private String apellidos;
	private String email;
	private String usuario;
	private String password;
	private String foto;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumnos")
	private List<Comentarios> idcomentarios;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumnos")
	private List<Matricula> idmatriculas;

	public Alumnos() {
		super();
	}

	public Alumnos(int idalumnos, String nombre, String apellidos, String email, String usuario, String password,
			String foto, List<Comentarios> comentarios, List<Matricula> matriculas) {
		super();
		this.idalumnos = idalumnos;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.foto = foto;
		this.idcomentarios = comentarios;
		this.idmatriculas = matriculas;
	}

	public int getIdAlumnos() {
		return idalumnos;
	}

	public void setIdAlumnos(int idAlumnos) {
		this.idalumnos = idAlumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Alumnos [idAlumnos=" + idalumnos + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", usuario=" + usuario + ", password=" + password + ", foto=" + foto + "]";
	}

}
