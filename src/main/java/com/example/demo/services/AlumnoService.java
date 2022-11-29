package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Alumno;
import com.example.demo.model.AlumnoModel;

public interface AlumnoService {
	public abstract List<AlumnoModel> listAllAlumnos();
	public abstract Alumno addAlumno(AlumnoModel alumnoModel);
	public abstract int removeAlumno(int id);
	public abstract Alumno updateAlumno(AlumnoModel alumnoModel);
	public abstract Alumno transform(AlumnoModel alumnoModel);
	public abstract AlumnoModel transform(Alumno alumno);
}