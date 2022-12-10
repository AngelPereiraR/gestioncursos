package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Noticia;
import com.example.demo.model.NoticiaModel;

public interface NoticiaService {
	public abstract List<NoticiaModel> listAllNoticias();

	public abstract Noticia addNoticia(NoticiaModel noticiaModel);

	public abstract int removeNoticia(int id);

	public abstract Noticia updateNoticia(NoticiaModel noticiaModel);

	public abstract Noticia transform(NoticiaModel noticiaModel);

	public abstract NoticiaModel transform(Noticia noticia);
}