package com.example.demo.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
import com.example.demo.model.AlumnoMatriculado;
import com.example.demo.model.CursoModel;
import com.example.demo.model.MatriculaModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.CursoService;
import com.example.demo.services.MatriculaService;
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
	
	@Autowired
	@Qualifier("matriculaService")
	private MatriculaService matriculaService;

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

	@Override
	public List<MatriculaModel> listMatriculasAlumno(Usuario id) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		return matriculaRepository.findById(id).stream().map(u->modelMapper.map(u, MatriculaModel.class)).collect(Collectors.toList());
	}

	@Override
	public Usuario findByEmail(String email) {
		Usuario user=userRepository.findByEmail(email);
		return user;
	}

	@Override
	public List<Usuario> findAllByRole(String role) {
		List<Usuario> profesores = userRepository.findAllByRole("ROLE_PROFESOR");
		return profesores;
	}

	@Override
	public List<AlumnoMatriculado> listMejoresAlumnosAdmin(List<UsuarioModel> alumnos, List<Matricula> matriculas) {
		List<AlumnoMatriculado> alumnosMatriculados = new ArrayList<>();
		for(UsuarioModel alumno : alumnos) {
			for(Matricula matricula : matriculas) {
				if(alumno.getId() == matricula.getId().getId()) {
					int index = 0;
					boolean existe = false;
					for(int k = 0; k < alumnosMatriculados.size(); k++) {
						if(alumnosMatriculados.get(k).getUsuarioModel().getId() == alumno.getId()) {
							index = k;
							existe = true;
						}
					}
					if(existe == true) {
						alumnosMatriculados.get(index).setCalificacion(alumnosMatriculados.get(index).getCalificacion() + matricula.getValoracion());
						alumnosMatriculados.get(index).setNumCursos(alumnosMatriculados.get(index).getNumCursos() + 1);
					}
					else {
						alumnosMatriculados.add(new AlumnoMatriculado(alumno, matricula, matricula.getValoracion(), 1, 0));
					}
				}
			}
		}
		List<AlumnoMatriculado> mejoresAlumnos = new ArrayList<>();
		int mejorNota = 0;
		for (AlumnoMatriculado alumno : alumnosMatriculados) {
			UsuarioModel alumnoModel = alumno.getUsuarioModel();
		    Matricula matricula = alumno.getMatricula();
		    int calificacion = alumno.getCalificacion();
			int numCursos = alumno.getNumCursos();
			float notaMedia = calificacion / (float) numCursos;
		    if(mejorNota == matricula.getValoracion()) {
		    	mejoresAlumnos.add(new AlumnoMatriculado(alumnoModel, matricula, calificacion, numCursos, notaMedia));
		    }
		    else if(mejorNota < matricula.getValoracion()){
		    	mejoresAlumnos.clear();
		    	mejoresAlumnos.add(new AlumnoMatriculado(alumnoModel, matricula, calificacion, numCursos, notaMedia));
		    	mejorNota = matricula.getValoracion();
		    }
		}
		return mejoresAlumnos;
	}

	@Override
	public List<AlumnoMatriculado> listNotasMediasAlumnos(List<UsuarioModel> alumnos, List<MatriculaModel> matriculas) {
		//Conseguir la nota total de todos los cursos matriculados por el alumno y el número de cursos en los que está matriculado
		List<AlumnoMatriculado> alumnosMatriculados = new ArrayList<>();
		for(UsuarioModel alumno : alumnos) {
			for(MatriculaModel matricula : matriculas) {
				if(alumno.getId() == matricula.getId().getId()) {
					int index = 0;
					boolean existe = false;
					for(int k = 0; k < alumnosMatriculados.size(); k++) {
						if(alumnosMatriculados.get(k).getUsuarioModel().getId() == alumno.getId()) {
							index = k;
							existe = true;
						}
					}
					if(existe == true) {
						alumnosMatriculados.get(index).setCalificacion(alumnosMatriculados.get(index).getCalificacion() + matricula.getValoracion());
						alumnosMatriculados.get(index).setNumCursos(alumnosMatriculados.get(index).getNumCursos() + 1);
					}
					else {
						alumnosMatriculados.add(new AlumnoMatriculado(alumno, matriculaService.transform(matricula), matricula.getValoracion(), 1, 0));
					}
				}
			}
		}
		
		//Conseguir las notas medias de los alumnos
		for(AlumnoMatriculado alumno : alumnosMatriculados) {
			int calificacion = alumno.getCalificacion();
			int numCursos = alumno.getNumCursos();
			float notaMedia = calificacion / (float) numCursos;
			alumno.setNotaMedia(notaMedia);
			
		}
		
		//Ordenar la lista de las notas medias
		alumnosMatriculados.sort(Comparator.comparing(AlumnoMatriculado::getNotaMedia).reversed());
		return alumnosMatriculados;
	}

	
}
