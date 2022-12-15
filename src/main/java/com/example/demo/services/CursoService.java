package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Curso;
import com.example.demo.model.CursoModel;

public interface CursoService {
	public abstract List<CursoModel> listAllCursos();

	public abstract Curso addCurso(CursoModel cursoModel);

	public abstract int removeCurso(int id);

	public abstract Curso updateCurso(CursoModel cursoModel);

	public abstract Curso transform(CursoModel cursoModel);

	public abstract CursoModel transform(Curso curso);

	public abstract CursoModel findCurso(int id);

}