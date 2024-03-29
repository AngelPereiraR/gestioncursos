package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Matricula;
import com.example.demo.entity.Usuario;
import com.example.demo.model.MatriculaModel;

public interface MatriculaService {
	public abstract List<MatriculaModel> listAllMatriculas();

	public abstract Matricula addMatricula(MatriculaModel matriculaModel);

	public abstract int removeMatricula(int id);

	public abstract Matricula updateMatricula(MatriculaModel matriculaModel);

	public abstract Matricula transform(MatriculaModel matriculaModel);

	public abstract MatriculaModel transform(Matricula matricula);

	public abstract int numMatriculasByIdcurso(Curso idcurso);
	
	public abstract List<Matricula> findByIdcurso(int id);
	
	public abstract Matricula findByIdAndIdcurso(Usuario usuario, Curso curso);	
	
}