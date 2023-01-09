package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Matricula;
import com.example.demo.entity.Usuario;

@Repository("matriculaRepository")
public interface MatriculaRepository extends JpaRepository<Matricula, Serializable> {
	public abstract List<Matricula> findByIdcurso(Curso idcurso);
	
	public abstract List<Matricula> findById(Usuario id);
	
	public abstract Matricula findByIdAndIdcurso(Usuario id, Curso idcurso);
	
	
}
