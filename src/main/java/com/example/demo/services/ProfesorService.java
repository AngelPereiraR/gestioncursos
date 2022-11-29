package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Profesor;
import com.example.demo.model.ProfesorModel;

public interface ProfesorService {
	public abstract List<ProfesorModel> listAllProfesores();
	public abstract Profesor addProfesor(ProfesorModel profesorModel);
	public abstract int removeProfesor(int id);
	public abstract Profesor updateProfesor(ProfesorModel profesorModel);
	public abstract Profesor transform(ProfesorModel profesorModel);
	public abstract ProfesorModel transform(Profesor profesor);
}