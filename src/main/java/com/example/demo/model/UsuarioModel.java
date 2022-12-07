package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Curso;
import com.example.demo.entity.Matricula;
import com.example.demo.entity.Noticia;

public class UsuarioModel {

	private int id;

	private String nombre;

	private String apellidos;

	private String email;

	private String password;

	private String foto;

	private String role;

	private List<Noticia> idnoticia;

	private List<Comentario> comentario;

	private List<Matricula> matricula;

	private List<Curso> idcurso;
	
	public UsuarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioModel(int id, String nombre, String apellidos, String email, String password, String foto,
			String role, List<Noticia> idnoticia, List<Comentario> comentario, List<Matricula> matricula,
			List<Curso> idcurso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.foto = foto;
		this.role = role;
		this.idnoticia = idnoticia;
		this.comentario = comentario;
		this.matricula = matricula;
		this.idcurso = idcurso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Noticia> getIdnoticia() {
		return idnoticia;
	}

	public void setIdnoticia(List<Noticia> idnoticia) {
		this.idnoticia = idnoticia;
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

	public List<Curso> getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(List<Curso> idcurso) {
		this.idcurso = idcurso;
	}

}
