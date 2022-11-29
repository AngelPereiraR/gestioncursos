package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idalumno;

	@Size(max = 45)
	private String nombre;

	@Size(max = 45)
	private String apellidos;

	@Size(max = 45)
	private String role;

	@Size(max = 45)
	private String email;

	@Size(max = 45)
	private String usuario;

	@Size(max = 45)
	private String password;

	@Size(max = 45)
	private String foto;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
	private List<Comentario> idcomentario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
	private List<Matricula> idmatricula;

	public Alumno() {
		super();
	}

	public Alumno(int idalumno, @Size(max = 45) String nombre, @Size(max = 45) String role,
			@Size(max = 45) String apellidos, @Size(max = 45) String email, @Size(max = 45) String usuario,
			@Size(max = 45) String password, @Size(max = 45) String foto, List<Comentario> idcomentario,
			List<Matricula> idmatricula) {
		super();
		this.idalumno = idalumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.foto = foto;
		this.idcomentario = idcomentario;
		this.idmatricula = idmatricula;
		this.setRole(role);
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

	@Override
	public String toString() {
		return "Alumno [idalumno=" + idalumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", usuario=" + usuario + ", password=" + password + ", foto=" + foto + ", idcomentario="
				+ idcomentario + ", idmatricula=" + idmatricula + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
