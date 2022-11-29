package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alumno;
import com.example.demo.model.AlumnoModel;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.services.AlumnoService;

@Service("alumnoService")
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	@Qualifier("alumnoRepository")
	private AlumnoRepository alumnoRepository;
	
	@Override
	public List<AlumnoModel> listAllAlumnos() {
		List<AlumnoModel> alumnos = new ArrayList<AlumnoModel>();
		for(Alumno alumno: alumnoRepository.findAll())
			alumnos.add(transform(alumno));
		return alumnos;
	}

	@Override
	public Alumno addAlumno(AlumnoModel alumnoModel) {
		return alumnoRepository.save(transform(alumnoModel));
	}

	@Override
	public int removeAlumno(int id) {
		alumnoRepository.deleteById(id);
		return 0;
	}

	@Override
	public Alumno updateAlumno(AlumnoModel alumnoModel) {
		return alumnoRepository.save(transform(alumnoModel));
	}

	@Override
	public Alumno transform(AlumnoModel alumnoModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(alumnoModel, Alumno.class);
	}

	@Override
	public AlumnoModel transform(Alumno alumno) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(alumno, AlumnoModel.class);
	}

	
}
