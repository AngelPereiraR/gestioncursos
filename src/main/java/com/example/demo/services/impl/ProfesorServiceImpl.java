package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Profesor;
import com.example.demo.model.ProfesorModel;
import com.example.demo.repository.ProfesorRepository;
import com.example.demo.services.ProfesorService;

@Service("profesorService")
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	@Qualifier("profesorRepository")
	private ProfesorRepository profesorRepository;
	
	@Override
	public List<ProfesorModel> listAllProfesores() {
		List<ProfesorModel> profesores = new ArrayList<ProfesorModel>();
		for(Profesor profesor: profesorRepository.findAll())
			profesores.add(transform(profesor));
		return profesores;
	}

	@Override
	public Profesor addProfesor(ProfesorModel profesorModel) {
		return profesorRepository.save(transform(profesorModel));
	}

	@Override
	public int removeProfesor(int id) {
		profesorRepository.deleteById(id);
		return 0;
	}

	@Override
	public Profesor updateProfesor(ProfesorModel profesorModel) {
		return profesorRepository.save(transform(profesorModel));
	}

	@Override
	public Profesor transform(ProfesorModel profesorModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(profesorModel, Profesor.class);
	}

	@Override
	public ProfesorModel transform(Profesor profesor) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(profesor, ProfesorModel.class);
	}

	
}
