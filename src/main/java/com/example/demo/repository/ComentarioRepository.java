package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Curso;
import com.example.demo.entity.Usuario;

@Repository("comentarioRepository")
public interface ComentarioRepository extends JpaRepository<Comentario, Serializable> {
	public abstract List<Comentario> findByAlumno(Usuario id);
	
	public abstract List<Comentario> findByIdcurso(Curso curso);
}
