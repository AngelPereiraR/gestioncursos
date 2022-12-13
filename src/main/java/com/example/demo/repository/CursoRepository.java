package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Usuario;

@Repository("cursoRepository")
public interface CursoRepository extends JpaRepository<Curso, Serializable> {
	public abstract List<Curso> findByIdprofesor(Usuario id);

	public abstract List<Curso> findByOrderByFechaInicioDesc();

	public abstract List<Curso> findByOrderByFechaInicioAsc();
	
	public abstract List<Curso> findByOrderByFechaFinDesc();

	public abstract List<Curso> findByOrderByFechaFinAsc();
}
