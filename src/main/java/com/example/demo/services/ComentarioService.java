package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Comentario;
import com.example.demo.model.ComentarioModel;

public interface ComentarioService {
	public abstract List<ComentarioModel> listAllComentarios();

	public abstract Comentario addComentario(ComentarioModel comentarioModel);

	public abstract int removeComentario(int id);

	public abstract Comentario updateComentario(ComentarioModel comentarioModel);

	public abstract Comentario transform(ComentarioModel comentarioModel);

	public abstract ComentarioModel transform(Comentario comentario);
}