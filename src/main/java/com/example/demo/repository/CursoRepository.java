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

	public abstract List<Curso> findByIdprofesorOrderByFechaInicioDesc(Usuario id);

	public abstract List<Curso> findByIdprofesorOrderByFechaInicioAsc(Usuario id);
	
	public abstract List<Curso> findByFechaInicioAfterAndIdprofesor(String actual, Usuario id);

	public abstract List<Curso> findByFechaFinBeforeAndIdprofesor(String actual, Usuario id);

	public abstract List<Curso> findByFechaInicioBeforeAndFechaFinAfterAndIdprofesor(String actual, String actual1, Usuario id);
	
	public abstract List<Curso> findByNivelBetween(int nivel1, int nivel2);


	//public abstract List<Curso> findByOrderByFechaFinDesc();

}
