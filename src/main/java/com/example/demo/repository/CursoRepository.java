package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Usuario;

@Repository("cursoRepository")
public interface CursoRepository extends JpaRepository<Curso, Serializable> {
	public abstract List<Curso> findByProfesor(Usuario id);

	public abstract List<Curso> findByProfesorOrderByFechaInicioDesc(Usuario id);

	public abstract List<Curso> findByProfesorOrderByFechaInicioAsc(Usuario id);
	
	public abstract List<Curso> findByFechaInicioAfterAndProfesor(String actual, Usuario id);

	public abstract List<Curso> findByFechaFinBeforeAndProfesor(String actual, Usuario id);

	public abstract List<Curso> findByFechaInicioBeforeAndFechaFinAfterAndProfesor(String actual, String actual1, Usuario id);
	
	public abstract List<Curso> findByNivelBetween(int nivel1, int nivel2);

}
