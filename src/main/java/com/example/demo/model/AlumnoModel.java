package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Matricula;

public class AlumnoModel {

	private int idalumno;

	private String nombre;

	private String apellidos;

	private String email;


	private String password;

	private String foto;
	
	private String role;

	private List<Comentario> comentario;

	private List<Matricula> matricula;

	public AlumnoModel() {
		super();
		this.role="alumno";
		// TODO Auto-generated constructor stub
	}

	public AlumnoModel(int idalumno, String nombre, String apellidos, String email,  String password,
			String foto, List<Comentario> comentario, List<Matricula> matricula) {
		super();
		this.idalumno = idalumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		
		this.password = password;
		this.foto = foto;
		this.comentario = comentario;
		this.matricula = matricula;
	}

	public int getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
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

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "AlumnoModel [idalumno=" + idalumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ",  , password=" + password + ", foto=" + foto + ", comentario="
				+ comentario + ", matricula=" + matricula + "]";
	}

}
