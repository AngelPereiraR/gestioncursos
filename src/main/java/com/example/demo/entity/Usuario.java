package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private int id;

	@Size(max = 45)
	private String nombre;

	@Size(max = 45)
	private String apellidos;

	@Column(name = "email", unique = true, nullable = false)
	@Size(max = 45)
	private String email;

	@Column(name = "password", nullable = false)
	@Size(max = 45)
	private String password;

	private boolean enabled;

	@Size(max = 45)
	private String role;

	@Size(max = 45)
	private String foto;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	private List<Comentario> idcomentario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	private List<Matricula> idmatricula;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	private List<Noticia> idnoticia;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	private List<Curso> idcurso;

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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

	public List<Noticia> getIdnoticia() {
		return idnoticia;
	}

	public void setIdnoticia(List<Noticia> idnoticia) {
		this.idnoticia = idnoticia;
	}

	public List<Curso> getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(List<Curso> idcurso) {
		this.idcurso = idcurso;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, @Size(max = 45) String nombre, @Size(max = 45) String apellidos,
			@Size(max = 45) String email, @Size(max = 45) String password, boolean enabled, @Size(max = 45) String role,
			@Size(max = 45) String foto, List<Comentario> idcomentario, List<Matricula> idmatricula,
			List<Noticia> idnoticia, List<Curso> idcurso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.foto = foto;
		this.idcomentario = idcomentario;
		this.idmatricula = idmatricula;
		this.idnoticia = idnoticia;
		this.idcurso = idcurso;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", enabled=" + enabled + ", role=" + role + ", foto=" + foto
				+ ", idcomentario=" + idcomentario + ", idmatricula=" + idmatricula + ", idnoticia=" + idnoticia
				+ ", idcurso=" + idcurso + "]";
	}

}
