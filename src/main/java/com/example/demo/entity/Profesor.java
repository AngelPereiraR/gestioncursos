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
	private int idprofesor;
	private String nombre;
	private String apellidos;
	private String role;
	private String email;
	private String usuario;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesor")
	private List<Curso> idcurso;

	public Profesor() {
		super();
	}

	public Profesor(int idprofesor, String nombre, String role,String apellidos, String email, String usuario, String password,
			List<Curso> idcurso) {
		super();
		this.idprofesor = idprofesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.idcurso = idcurso;
		this.setRole(role);
	}

	public int getIdprofesor() {
		return idprofesor;
	}

	public void setIdprofesor(int idprofesor) {
		this.idprofesor = idprofesor;
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

	public List<Curso> getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(List<Curso> idcurso) {
		this.idcurso = idcurso;
	}

	@Override
	public String toString() {
		return "Profesor [idprofesor=" + idprofesor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", usuario=" + usuario + ", password=" + password + ", idcurso=" + idcurso + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
