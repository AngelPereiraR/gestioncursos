package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UsuarioService;

@Service("userService")
public class UsuarioServiceImp implements UserDetailsService, UsuarioService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.example.demo.entity.Usuario usuario = userRepository.findByEmail(email);

		UserBuilder builder = null;
		if (usuario != null) {
			builder = User.withUsername(email);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return builder.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public com.example.demo.entity.Usuario registrar(com.example.demo.entity.Usuario user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		user.setEnabled(true);
		return userRepository.save(user);
	}

	@Override
	public Usuario transform(UsuarioModel usuarioModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(usuarioModel, Usuario.class);
	}

	@Override
	public UsuarioModel transform(Usuario user) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, UsuarioModel.class);
	}

	@Override
	public List<UsuarioModel> listAllAlumnos() {
		List<UsuarioModel> alumnos = new ArrayList<UsuarioModel>();
		for (Usuario user : userRepository.findAll()) {
			if (user.getRole().equals("ROLE_ALUMNO"))
				alumnos.add(transform(user));
		}
		return alumnos;
	}

	@Override
	public Usuario addAlumno(UsuarioModel usuarioModel) {
		
		return userRepository.save(transform(usuarioModel));
	}

	@Override
	public int removeAlumno(int id) {
		userRepository.deleteById(id);
		return 0;
	}

	@Override
	public Usuario updateAlumno(UsuarioModel usuarioModel) {
		return userRepository.save(transform(usuarioModel));
	}

	@Override
	public List<UsuarioModel> listAllProfesores() {
		List<UsuarioModel> profesores = new ArrayList<UsuarioModel>();
		for (Usuario user : userRepository.findAll()) {
			if (user.getRole().equals("ROLE_PROFESOR"))
				profesores.add(transform(user));
		}
		return profesores;
	}

	@Override
	public Usuario addProfesor(UsuarioModel usuarioModel) {
		
		return userRepository.save(transform(usuarioModel));
	}

	@Override
	public int removeProfesor(int id) {
		userRepository.deleteById(id);
		return 0;
	}

	@Override
	public Usuario updateProfesor(UsuarioModel usuarioModel) {
		return userRepository.save(transform(usuarioModel));
	}

	@Override
	public List<UsuarioModel> listAllAdministradores() {
		List<UsuarioModel> administradores = new ArrayList<UsuarioModel>();
		for (Usuario user : userRepository.findAll()) {
			if (user.getRole().equals("ROLE_ADMINISTRADOR"))
				administradores.add(transform(user));
		}
		return administradores;
	}

	@Override
	public Usuario addAdministrador(UsuarioModel usuarioModel) {
		return userRepository.save(transform(usuarioModel));
	}

	@Override
	public int removeAdministrador(int id) {
		userRepository.deleteById(id);
		return 0;
	}

	@Override
	public Usuario updateAdministrador(UsuarioModel usuarioModel) {
		return userRepository.save(transform(usuarioModel));
	}

}
