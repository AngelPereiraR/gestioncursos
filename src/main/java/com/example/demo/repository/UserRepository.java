package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Matricula;
import com.example.demo.entity.Usuario;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Usuario, Serializable> {
	public abstract Usuario findByEmail(String email);

	public abstract Usuario findByRole(String role);

	public abstract List<Usuario> findAllByRole(String role);
	
	public abstract List<Usuario> findAllByIdmatriculaIn(List<Matricula> matriculas);
}
