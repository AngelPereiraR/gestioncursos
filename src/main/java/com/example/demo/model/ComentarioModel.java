package com.example.demo.model;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Usuario;

public class ComentarioModel {

	private int idcomentario;

	private Usuario user;

	private Curso curso;

	private String comentario;

	public ComentarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioModel(int idcomentario, Usuario user, Curso curso, String comentario) {
		super();
		this.idcomentario = idcomentario;
		this.user = user;
		this.curso = curso;
		this.comentario = comentario;
	}

	public int getIdcomentario() {
		return idcomentario;
	}

	public void setIdcomentario(int idcomentario) {
		this.idcomentario = idcomentario;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario alumno) {
		this.user = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "ComentariosModel [idcomentario=" + idcomentario + ", usuario=" + user + ", curso=" + curso
				+ ", comentario=" + comentario + "]";
	}

}
