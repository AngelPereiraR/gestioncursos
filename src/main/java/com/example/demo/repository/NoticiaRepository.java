package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Noticia;
import com.example.demo.entity.Usuario;

@Repository("noticiaRepository")
public interface NoticiaRepository extends JpaRepository<Noticia, Serializable> {
	
	public abstract List<Noticia> findByOrderByFechaCreacionDesc();
}
