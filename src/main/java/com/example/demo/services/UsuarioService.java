package com.example.demo.services;

import java.text.ParseException;
import java.util.List;

import com.example.demo.entity.Matricula;
import com.example.demo.entity.Usuario;
import com.example.demo.model.AlumnoMatriculado;
import com.example.demo.model.CursoModel;
import com.example.demo.model.MatriculaModel;
import com.example.demo.model.UsuarioModel;

public interface UsuarioService {

	public abstract Usuario transform(UsuarioModel usuarioModel);

	public abstract UsuarioModel transform(Usuario user);

	public abstract UsuarioModel findUsuario(int id);
	
	public abstract Usuario findByEmail(String email);
	
	public abstract List<Usuario> findAllByRole(String role);

	// Alumno

	public abstract List<UsuarioModel> listAllAlumnos();

	public abstract Usuario addAlumno(UsuarioModel usuarioModel);

	public abstract int removeAlumno(int id);

	public abstract Usuario updateAlumno(UsuarioModel usuarioModel);

	public abstract int activateAlumno(int id);

	public abstract int deactivateAlumno(int id);
	
	public abstract List<CursoModel> listCursosAlumno(int nivel);
	
	public abstract List<MatriculaModel> listMatriculasAlumno(Usuario id);
	
	public abstract List<AlumnoMatriculado> listMejoresAlumnosAdmin(List<UsuarioModel> alumnos, List<Matricula> matriculas);
	
	public abstract List<AlumnoMatriculado> listNotasMediasAlumnos(List<UsuarioModel> alumnos, List<MatriculaModel> matriculas);

	// Profesor

	public abstract List<UsuarioModel> listAllProfesores();

	public abstract Usuario addProfesor(UsuarioModel usuarioModel);

	public abstract int removeProfesor(int id);

	public abstract Usuario updateProfesor(UsuarioModel usuarioModel);

	public abstract List<CursoModel> listAllCursos(UsuarioModel usuarioModel);

	public abstract List<CursoModel> listOrderCursosByFechaDesc(UsuarioModel usuarioModel);

	public abstract List<CursoModel> listOrderCursosByFechaAsc(UsuarioModel usuarioModel);

	public abstract List<CursoModel> listOrderCursosByImpartidos(UsuarioModel usuarioModel) throws ParseException;

	public abstract List<CursoModel> listOrderCursosByImpartiendo(UsuarioModel usuarioModel) throws ParseException;

	public abstract List<CursoModel> listOrderCursosByImpartiran(UsuarioModel usuarioModel) throws ParseException;

	// Administrador

	public abstract List<UsuarioModel> listAllAdministradores();

	public abstract Usuario addAdministrador(UsuarioModel usuarioModel);

	public abstract int removeAdministrador(int id);

	public abstract Usuario updateAdministrador(UsuarioModel usuarioModel);
	
	public abstract List<UsuarioModel> listAlumnosByMatricula(int idcurso);

}
