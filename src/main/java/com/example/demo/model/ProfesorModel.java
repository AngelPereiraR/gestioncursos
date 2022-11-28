package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Curso;

public class ProfesorModel {

	private int idprofesor;

	private String nombre;

	private String apellidos;

	private String email;

	private String usuario;

	private String password;

	private List<Curso> idcurso;

	public ProfesorModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfesorModel(int idprofesore, String nombre, String apellidos, String email, String usuario,
			String password, List<Curso> idcurso) {
		super();
		this.idprofesor = idprofesore;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.idcurso = idcurso;
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

	public List<Curso> getCurso() {
		return idcurso;
	}

	public void setCurso(List<Curso> curso) {
		this.idcurso = curso;
	}

	@Override
	public String toString() {
		return "ProfesoresModel [idprofesor=" + idprofesor + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", usuario=" + usuario + ", password=" + password + ", curso=" + idcurso + "]";
	}

}
