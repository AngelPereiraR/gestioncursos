package com.example.demo.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.example.demo.entity.Curso;
import com.example.demo.entity.Matricula;
import com.example.demo.entity.Usuario;
import com.example.demo.model.CursoModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.CursoService;
import com.example.demo.services.UsuarioService;

@Service("userService")
public class UsuarioServiceImp implements UserDetailsService, UsuarioService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("cursoRepository")
	private CursoRepository cursoRepository;
	
	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;
	
	@Autowired
	@Qualifier("matriculaRepository")
	private MatriculaRepository matriculaRepository;


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = userRepository.findByEmail(email);

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

	public Usuario registrar(Usuario user) {
		Usuario u = userRepository.findByEmail(user.getEmail());
		if (u != null) {
			return null;
		}
		if (user.getRole().equals("ROLE_ALUMNO")) {
			user.setPassword(passwordEncoder().encode(user.getPassword()));
			user.setEnabled(false);
		} else {
			user.setPassword(passwordEncoder().encode(user.getPassword()));
			user.setEnabled(true);
		}

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
	public int activateAlumno(int id) {
		UsuarioModel user = findUsuario(id);
		if (user.getRole().equals("ROLE_ALUMNO")) {
			user.setEnabled(true);
			userRepository.save(transform(user));
		}
		return 0;
	}

	@Override
	public int deactivateAlumno(int id) {
		UsuarioModel user = findUsuario(id);
		if (user.getRole().equals("ROLE_ALUMNO")) {
			user.setEnabled(false);
			userRepository.save(transform(user));
		}
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

	@Override
	public UsuarioModel findUsuario(int id) {

		return transform(userRepository.findById(id).orElse(null));
	}

	@Override
	public List<CursoModel> listAllCursos(UsuarioModel usuarioModel) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();

		return cursoRepository.findByProfesor(transform(usuarioModel)).stream()
				.map(c -> modelMapper.map(c, CursoModel.class)).collect(Collectors.toList());
	}

	@Override
	public List<CursoModel> listOrderCursosByFechaDesc(UsuarioModel usuarioModel) {
		ModelMapper modelMapper = new ModelMapper();
		return cursoRepository.findByProfesorOrderByFechaInicioDesc(transform(usuarioModel)).stream()
				.map(c -> modelMapper.map(c, CursoModel.class)).collect(Collectors.toList());

	}

	@Override
	public List<CursoModel> listOrderCursosByFechaAsc(UsuarioModel usuarioModel) {
		ModelMapper modelMapper = new ModelMapper();
		
		return cursoRepository.findByProfesorOrderByFechaInicioAsc(transform(usuarioModel)).stream()
				.map(c -> modelMapper.map(c, CursoModel.class)).collect(Collectors.toList());

	}

	@Override
	public List<CursoModel> listOrderCursosByImpartidos(UsuarioModel usuarioModel) throws ParseException {
		Calendar c1 = Calendar.getInstance();
		String fechaActual = ( Integer.toString(c1.get(Calendar.YEAR)) + "-" + Integer.toString(c1.get(Calendar.MONTH)+1) + "-" + Integer.toString(c1.get(Calendar.DATE))+" "+Integer.toString(c1.get(Calendar.HOUR_OF_DAY))+"OO:OO");
		
		System.out.println(fechaActual);
		ModelMapper modelMapper = new ModelMapper();
		return cursoRepository
				.findByFechaFinBeforeAndProfesor(fechaActual, transform(usuarioModel)).stream()
				.map(c -> modelMapper.map(c, CursoModel.class)).collect(Collectors.toList());

	}

	@Override
	public List<CursoModel> listOrderCursosByImpartiendo(UsuarioModel usuarioModel) throws ParseException {
		Calendar c1 = Calendar.getInstance();
		String fechaActual = ( Integer.toString(c1.get(Calendar.YEAR)) + "-" + Integer.toString(c1.get(Calendar.MONTH)+1) + "-" + Integer.toString(c1.get(Calendar.DATE))+" "+Integer.toString(c1.get(Calendar.HOUR_OF_DAY))+"OO:OO");

		ModelMapper modelMapper = new ModelMapper();
		System.out.println(fechaActual);
		return cursoRepository
				.findByFechaInicioBeforeAndFechaFinAfterAndProfesor(fechaActual, fechaActual, transform(usuarioModel)).stream()
				.map(c -> modelMapper.map(c, CursoModel.class)).collect(Collectors.toList());

	}

	@Override
	public List<CursoModel> listOrderCursosByImpartiran(UsuarioModel usuarioModel) throws ParseException {
	
		Calendar c1 = Calendar.getInstance();
		
		String fechaActual = ( Integer.toString(c1.get(Calendar.YEAR)) + "-" + Integer.toString(c1.get(Calendar.MONTH)+1) + "-" + Integer.toString(c1.get(Calendar.DATE))+" "+Integer.toString(c1.get(Calendar.HOUR_OF_DAY))+"OO:OO");
		ModelMapper modelMapper = new ModelMapper();
		System.out.println(fechaActual);
		return cursoRepository.findByFechaInicioAfterAndProfesor(fechaActual, transform(usuarioModel)).stream()
				.map(c -> modelMapper.map(c, CursoModel.class)).collect(Collectors.toList());

	}

	@Override
	public List<CursoModel> listCursosAlumno(int nivel) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		if(nivel<=4) {
			return cursoRepository.findByNivelBetween(0, 4).stream().map(c->modelMapper.map(c, CursoModel.class)).collect(Collectors.toList());		
		}else if(nivel>=5 && nivel<=8){
			return cursoRepository.findByNivelBetween(5, 8).stream().map(c->modelMapper.map(c, CursoModel.class)).collect(Collectors.toList());
			
		}else if(nivel>=9){
			return cursoRepository.findByNivelBetween(9, 10).stream().map(c->modelMapper.map(c, CursoModel.class)).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public List<UsuarioModel> listAlumnosByMatricula(int idcurso) {
		ModelMapper modelMapper = new ModelMapper();
		Optional<Curso> curso = cursoRepository.findById(idcurso);
		List<Matricula> matriculas = matriculaRepository.findByIdcurso(curso.get());
		List<UsuarioModel> alumnos = new ArrayList<UsuarioModel>();
		/*
		 * for(Matricula m : matriculas) {
		 * alumnos.add(transform(userRepository.findById(m.getIdalumno().getId()).get())
		 * ); }
		 */
		
		return userRepository.findAllByIdmatriculaIn(matriculas).stream().map(u->modelMapper.map(u, UsuarioModel.class)).collect(Collectors.toList());
	}

	
	
		

}
