package com.example.demo.model;

import java.util.Arrays;

import com.example.demo.entity.Comentarios;
import com.example.demo.entity.Matricula;

public class AlumnosModel {

	private int idalumnos;

	private String nombre;

	private String apellidos;

	private String email;

	private String usuario;

	private String password;

	private String foto;

	private Comentarios[] comentarios;

	private Matricula[] matriculas;

	public AlumnosModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlumnosModel(int idalumnos, String nombre, String apellidos, String email, String usuario, String password,
			String foto, Comentarios[] comentarios, Matricula[] matriculas) {
		super();
		this.idalumnos = idalumnos;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.foto = foto;
		this.comentarios = comentarios;
		this.matriculas = matriculas;
	}

	public int getIdalumnos() {
		return idalumnos;
	}

	public void setIdalumnos(int idalumnos) {
		this.idalumnos = idalumnos;
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

	public Comentarios[] getComentarios() {
		return comentarios;
	}

	public void setComentarios(Comentarios[] comentarios) {
		this.comentarios = comentarios;
	}

	public Matricula[] getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Matricula[] matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return "AlumnosModel [idalumnos=" + idalumnos + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", usuario=" + usuario + ", password=" + password + ", foto=" + foto + ", comentarios="
				+ Arrays.toString(comentarios) + ", matriculas=" + Arrays.toString(matriculas) + "]";
	}

}
