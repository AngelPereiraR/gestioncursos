package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Curso;
import com.example.demo.model.CursoModel;
import com.example.demo.repository.CursoRepository;
import com.example.demo.services.CursoService;

@Service("cursoService")
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	@Qualifier("cursoRepository")
	private CursoRepository cursoRepository;
	
	@Override
	public List<CursoModel> listAllCursos() {
		List<CursoModel> cursos = new ArrayList<CursoModel>();
		for(Curso curso: cursoRepository.findAll())
			cursos.add(transform(curso));
		return cursos;
	}

	@Override
	public Curso addCurso(CursoModel cursoModel) {
		return cursoRepository.save(transform(cursoModel));
	}

	@Override
	public int removeCurso(int id) {
		cursoRepository.deleteById(id);
		return 0;
	}

	@Override
	public Curso updateCurso(CursoModel cursoModel) {
		return cursoRepository.save(transform(cursoModel));
	}

	@Override
	public Curso transform(CursoModel cursoModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cursoModel, Curso.class);
	}

	@Override
	public CursoModel transform(Curso curso) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(curso, CursoModel.class);
	}

	
}
