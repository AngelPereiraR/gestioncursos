package com.example.demo.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
		for (Curso curso : cursoRepository.findAll())
			cursos.add(transform(curso));
		return cursos;
	}

	@Override
	public List<CursoModel> listAllOrderCursos() {
		List<CursoModel> cursos = new ArrayList<CursoModel>();

		for (Curso curso : cursoRepository.findByOrderByFechaInicioAsc())
			cursos.add(transform(curso));
		return cursos;
	}

	@Override
	public List<CursoModel> listOrderCursosByFechaDesc() {
		List<CursoModel> cursos = new ArrayList<CursoModel>();

		for (Curso curso : cursoRepository.findByOrderByFechaInicioDesc())
			cursos.add(transform(curso));
		return cursos;
	}

	@Override
	public List<CursoModel> listOrderCursosByFechaAsc() {
		List<CursoModel> cursos = new ArrayList<CursoModel>();

		for (Curso curso : cursoRepository.findByOrderByFechaInicioAsc())
			cursos.add(transform(curso));
		return cursos;
	}

	@Override
	public List<CursoModel> listOrderCursosByImpartidos() throws ParseException {
		List<CursoModel> cursos = new ArrayList<CursoModel>();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaActual = formato.parse(Calendar.YEAR + "-" + Calendar.MONTH + "-" + Calendar.DATE);

		for (Curso curso : cursoRepository.findByOrderByFechaFinDesc()) {
			Date fechaFin = formato.parse(curso.getFechaFin());
			if (fechaActual.after(fechaFin)) {
				cursos.add(transform(curso));
			}
		}
		return cursos;
	}

	@Override
	public List<CursoModel> listOrderCursosByImpartiendo() throws ParseException {
		List<CursoModel> cursos = new ArrayList<CursoModel>();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaActual = formato.parse(Calendar.YEAR + "-" + Calendar.MONTH + "-" + Calendar.DATE);

		for (Curso curso : cursoRepository.findByOrderByFechaFinDesc()) {
			Date fechaInicio = formato.parse(curso.getFechaInicio());
			Date fechaFin = formato.parse(curso.getFechaFin());

			if (fechaActual.after(fechaInicio) && fechaActual.before(fechaFin)) {
				cursos.add(transform(curso));

			}
		}
		return cursos;
	}

	@Override
	public List<CursoModel> listOrderCursosByImpartiran() throws ParseException {
		List<CursoModel> cursos = new ArrayList<CursoModel>();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaActual = formato.parse(Calendar.YEAR + "-" + Calendar.MONTH + "-" + Calendar.DATE);

		for (Curso curso : cursoRepository.findByOrderByFechaFinDesc()) {
			Date fechaInicio = formato.parse(curso.getFechaInicio());
			if (fechaActual.before(fechaInicio)) {
				cursos.add(transform(curso));
			}
		}
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

	@Override
	public CursoModel findCurso(int id) {

		return transform(cursoRepository.findById(id).orElse(null));
	}

}
