package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idprofesores;
	private String nombre;
	private String apellidos;
	private String email;
	private String usuario;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesores")
	private List<Cursos> idcurso;

	public Profesor() {
		super();
	}

	public Profesor(int idprofesores, String nombre, String apellidos, String email, String usuario, String password,
			List<Cursos> cursos) {
		super();
		this.idprofesores = idprofesores;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.idcurso = cursos;
	}

	public int getIdprofesores() {
		return idprofesores;
	}

	public void setIdprofesores(int idprofesores) {
		this.idprofesores = idprofesores;
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

	public List<Cursos> getCursos() {
		return idcurso;
	}

	public void setCursos(List<Cursos> cursos) {
		this.idcurso = cursos;
	}

	@Override
	public String toString() {
		return "Profesores [idprofesores=" + idprofesores + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", usuario=" + usuario + ", password=" + password + ", cursos=" + idcurso + "]";
	}

}
