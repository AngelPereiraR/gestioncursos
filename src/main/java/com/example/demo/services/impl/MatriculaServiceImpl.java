package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Matricula;
import com.example.demo.entity.Usuario;
import com.example.demo.model.MatriculaModel;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.services.CursoService;
import com.example.demo.services.MatriculaService;

@Service("matriculaService")
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	@Qualifier("matriculaRepository")
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;

	@Override
	public List<MatriculaModel> listAllMatriculas() {
		List<MatriculaModel> matriculas = new ArrayList<MatriculaModel>();
		for (Matricula matricula : matriculaRepository.findAll())
			matriculas.add(transform(matricula));
		return matriculas;
	}
	

	@Override
	public Matricula addMatricula(MatriculaModel matriculaModel) {
		return matriculaRepository.save(transform(matriculaModel));
	}

	@Override
	public int removeMatricula(int id) {
		matriculaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Matricula updateMatricula(MatriculaModel matriculaModel) {
		return matriculaRepository.save(transform(matriculaModel));
	}

	@Override
	public Matricula transform(MatriculaModel matriculaModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(matriculaModel, Matricula.class);
	}

	@Override
	public MatriculaModel transform(Matricula matricula) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(matricula, MatriculaModel.class);
	}
	
	@Override
	public int numMatriculasByIdcurso(Curso idcurso) {
		List<MatriculaModel> matriculas = new ArrayList<MatriculaModel>();
		for (Matricula matricula : matriculaRepository.findByIdcurso(idcurso))
			matriculas.add(transform(matricula));
		int num=matriculas.size();
		return num;
	}


	@Override
	public List<Matricula> findByIdcurso(int id) {
		List<Matricula> matriculas = matriculaRepository
		.findByIdcurso(cursoService.transform(cursoService.findCurso(id)));
		return matriculas;
	}


	@Override
	public Matricula findByIdAndIdcurso(Usuario usuario, Curso curso) {
		Matricula matricula = matriculaRepository.findByIdAndIdcurso(usuario, curso);
		return matricula;
	}
}
