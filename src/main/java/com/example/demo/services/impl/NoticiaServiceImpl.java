package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Noticia;
import com.example.demo.model.NoticiaModel;
import com.example.demo.repository.NoticiaRepository;
import com.example.demo.services.NoticiaService;

@Service("noticiaService")
public class NoticiaServiceImpl implements NoticiaService {

	@Autowired
	@Qualifier("noticiaRepository")
	private NoticiaRepository noticiaRepository;

	@Override
	public List<NoticiaModel> listAllNoticias() {
		List<NoticiaModel> noticias = new ArrayList<NoticiaModel>();
		for (Noticia noticia : noticiaRepository.findAll())
			noticias.add(transform(noticia));
		return noticias;
	}

	
	@Override
	public List<NoticiaModel> listAllOrderNoticias() {
		List<NoticiaModel> noticias = new ArrayList<NoticiaModel>();
		//noticiaRepository.findByOrderByFechaCreacionDesc()
		for (Noticia noticia : noticiaRepository.findAll())
			noticias.add(transform(noticia));
		return noticias;
	}
	@Override
	public Noticia addNoticia(NoticiaModel noticiaModel) {
		return noticiaRepository.save(transform(noticiaModel));
	}

	@Override
	public int removeNoticia(int id) {
		noticiaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Noticia updateNoticia(NoticiaModel noticiaModel) {
		return noticiaRepository.save(transform(noticiaModel));
	}

	@Override
	public Noticia transform(NoticiaModel NoticiaModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(NoticiaModel, Noticia.class);
	}

	@Override
	public NoticiaModel transform(Noticia noticia) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(noticia, NoticiaModel.class);
	}
	
	@Override
	public NoticiaModel findNoticia(int id) {
		return transform(noticiaRepository.findById(id).orElse(null));
	}

}
