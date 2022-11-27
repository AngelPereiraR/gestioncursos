package com.example.demo.model;

import java.util.Arrays;

import com.example.demo.entity.Cursos;

public class ProfesoresModel {

	private int idprofesores;

	private String nombre;

	private String apellidos;

	private String email;

	private String usuario;

	private String password;

	private Cursos[] cursos;

	public ProfesoresModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfesoresModel(int idprofesores, String nombre, String apellidos, String email, String usuario,
			String password, Cursos[] cursos) {
		super();
		this.idprofesores = idprofesores;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.cursos = cursos;
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

	public Cursos[] getCursos() {
		return cursos;
	}

	public void setCursos(Cursos[] cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "ProfesoresModel [idprofesores=" + idprofesores + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", usuario=" + usuario + ", password=" + password + ", cursos="
				+ Arrays.toString(cursos) + "]";
	}

}
