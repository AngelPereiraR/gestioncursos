package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comentario;
import com.example.demo.model.ComentarioModel;
import com.example.demo.repository.ComentarioRepository;
import com.example.demo.services.ComentarioService;

@Service("comentarioService")
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	@Qualifier("comentarioRepository")
	private ComentarioRepository comentarioRepository;

	@Override
	public List<ComentarioModel> listAllComentarios() {
		List<ComentarioModel> comentarios = new ArrayList<ComentarioModel>();
		for (Comentario comentario : comentarioRepository.findAll())
			comentarios.add(transform(comentario));
		return comentarios;
	}

	@Override
	public Comentario addComentario(ComentarioModel comentarioModel) {
		return comentarioRepository.save(transform(comentarioModel));
	}

	@Override
	public int removeComentario(int id) {
		comentarioRepository.deleteById(id);
		return 0;
	}

	@Override
	public Comentario updateComentario(ComentarioModel comentarioModel) {
		return comentarioRepository.save(transform(comentarioModel));
	}

	@Override
	public Comentario transform(ComentarioModel comentarioModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(comentarioModel, Comentario.class);
	}

	@Override
	public ComentarioModel transform(Comentario comentario) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(comentario, ComentarioModel.class);
	}

}
