package com.example.demo.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Curso;
import com.example.demo.entity.Matricula;
import com.example.demo.entity.Usuario;
import com.example.demo.model.ComentarioModel;
import com.example.demo.model.CursoModel;
import com.example.demo.model.MatriculaModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.ComentarioService;
import com.example.demo.services.CursoService;
import com.example.demo.services.MatriculaService;
import com.example.demo.services.UsuarioService;

@Controller

public class CourseController {
	private static final String COURSES_VIEW = "cursos";
	private static final String COURSES2_VIEW = "cursosSolicitados";
	private static final String ALUMNOS_VIEW = "alumnosCurso";
	private static final String FORM_VIEW = "formCurso";

	private static final String COMENTARIOS_VIEW = "comentarios";

	private static final String FORM_VIEWCOMENTARIO = "formComentario";


	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;
	
	@Autowired
	@Qualifier("comentarioService")
	private ComentarioService comentarioService;

	@Autowired
	@Qualifier("userService")
	private UsuarioService userService;

	@Autowired
	@Qualifier("matriculaRepository")
	private MatriculaRepository matriculaRepository;

	@Autowired
	@Qualifier("matriculaService")
	private MatriculaService matriculaService;

	@Autowired
	@Qualifier("userRepository")
	public UserRepository userRepository;
	

	@GetMapping("/admin/listCursos")
	public ModelAndView listCursos() {
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("cursos", cursoService.listAllCursos());
		return mav;
	}

	@GetMapping("/admin/listAlumnos/{id}")
	public ModelAndView listAlumnosAdmin(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ALUMNOS_VIEW);
		List<UsuarioModel> alumnos = userService.listAlumnosByMatricula(id);
		List<Matricula> matriculas = matriculaRepository
				.findByIdcurso(cursoService.transform(cursoService.findCurso(id)));
		Map<UsuarioModel, Matricula> map = new HashMap<UsuarioModel, Matricula>();
		for (UsuarioModel alumno : alumnos) {
			for (Matricula matricula : matriculas) {
				map.put(alumno, matricula);
			}
		}
		mav.addObject("map", map);
		return mav;
	}

	@PostMapping("/profesor/listAlumnos/{idCurso}/{idAlumno}")
	public String calificar(@PathVariable("idCurso") int idCurso, @PathVariable("idAlumno") int idAlumno,
			@ModelAttribute("nota") String nota, RedirectAttributes flash) {
		Usuario usuario = userService.transform(userService.findUsuario(idAlumno));
		Curso curso = cursoService.transform(cursoService.findCurso(idCurso));
		Matricula matricula = matriculaRepository.findByIdAndIdcurso(usuario, curso);
		matricula.setValoracion(Integer.parseInt(nota));
		matriculaService.updateMatricula(matriculaService.transform(matricula));
		flash.addFlashAttribute("succes", "curso actualizado satisfactoriamente");
		return "redirect:/profesor/listCursos";

	}

	
	@PostMapping("/alumno/comentarCurso/{id}")
	public String commentCurso(@PathVariable(name = "id") Integer id,@ModelAttribute("comentario") ComentarioModel comentarioModel,
			RedirectAttributes flash) {

			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			Usuario user=userRepository.findByEmail(email);
			CursoModel curso =cursoService.findCurso(id);

			comentarioModel.setUser(user);
			comentarioModel.setCurso(cursoService.transform(curso));
			comentarioService.addComentario(comentarioModel);

			flash.addFlashAttribute("succes", "comentario añadido satisfactoriamente");
			return "redirect:/alumno/listCursos";


	}
	
	@GetMapping("/alumno/formComentario/{id}")
	public String formComentario(@PathVariable(name = "id", required = false) Integer id, Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();

			model.addAttribute("curso" ,id);
			model.addAttribute("comentario", new Comentario());

		return FORM_VIEWCOMENTARIO;
	}
	

	@GetMapping("/profesor/listAlumnos/{id}")
	public ModelAndView listAlumnosProfesor(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ALUMNOS_VIEW);
		CursoModel curso = cursoService.findCurso(id);
		List<UsuarioModel> alumnos = userService.listAlumnosByMatricula(id);
		List<Matricula> matriculas = matriculaRepository
				.findByIdcurso(cursoService.transform(cursoService.findCurso(id)));
		Map<UsuarioModel, Matricula> map = new HashMap<UsuarioModel, Matricula>();
		for (UsuarioModel alumno : alumnos) {
			for (Matricula matricula : matriculas) {
				map.put(alumno, matricula);
			}
		}
		mav.addObject("map", map);
		mav.addObject("curso", curso);
		mav.addObject("localDate", Date.valueOf(LocalDate.now()));
		mav.addObject("cursoFecha", Date.valueOf(curso.getFechaFin()));
		return mav;
	}

	@GetMapping("/alumno/listComentarios/{id}")
	public ModelAndView listComentariosAlumno(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(COMENTARIOS_VIEW);
		Curso curso= cursoService.transform(cursoService.findCurso(id));
		List<ComentarioModel> comentarios = comentarioService.findComentarioByCurso(curso);
		
		mav.addObject("comentarios", comentarios);
		return mav;
	}

	@PostMapping("/admin/addCurso")
	public String addCurso(@ModelAttribute("curso") CursoModel cursoModel, RedirectAttributes flash) {
		if (cursoModel.getIdcurso() == 0) {
			cursoService.addCurso(cursoModel);

			flash.addFlashAttribute("succes", "curso añadido satisfactoriamente");
			return "redirect:/admin/listCursos";
		} else {
			cursoService.updateCurso(cursoModel);

			flash.addFlashAttribute("succes", "curso actualizado satisfactoriamente");
			return "redirect:/admin/listCursos";

		}

	}

	@GetMapping("/admin/removeCurso/{id}")
	public String deleteCourse(@PathVariable("id") int id, RedirectAttributes flash) {
		cursoService.removeCurso(id);

		flash.addFlashAttribute("succes", "curso eliminado correctamente");
		return "redirect:/admin/listCursos";

	}

	@GetMapping(value = { "/admin/formCurso/{id}", "/admin/formCurso" })
	public String formCurso(@PathVariable(name = "id", required = false) Integer id, Model model) {
		List<Usuario> profesores = userRepository.findAllByRole("ROLE_PROFESOR");
		model.addAttribute("profesores", profesores);
		if (id == null) {
			model.addAttribute("curso", new Curso());
		} else {
			model.addAttribute("curso", cursoService.findCurso(id));
		}
		return FORM_VIEW;
	}

	@PostMapping("/alumno/matricular/{idcurso}")
	public String addMatricula(@PathVariable("idcurso") int idCurso, RedirectAttributes flash) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = userRepository.findByEmail(email);
		Curso curso = cursoService.transform(cursoService.findCurso(idCurso));
		MatriculaModel matriculaModel = new MatriculaModel();
		matriculaModel.setId(usuario);
		matriculaModel.setIdcurso(curso);
		matriculaService.addMatricula(matriculaModel);

		return "redirect:/alumno/listCursos";

	}
	
	@GetMapping("admin/lisCursosSolicitados")
	public ModelAndView listCursosSolicitados() {
		List<CursoModel>cursos=cursoService.listAllCursos();
		List<CursoModel>cursosOrdenados = null;
		boolean mayor=false;
		ModelAndView mav = new ModelAndView(COURSES2_VIEW);
		if(cursos.size()==1) {
			mav.addObject("cursos",cursos);
		}else {
		for(int i =0; i<cursos.size(); i++) {
			for(int j =0; j<cursos.size()-1; j++) {
				
				if(matriculaService.numMatriculasByIdcurso(cursoService.transform(cursos.get(i)))>matriculaService.numMatriculasByIdcurso(cursoService.transform(cursos.get(j)))) {
					mayor=true;
				}
				if(mayor==true) {
					cursosOrdenados.add(cursos.get(i));
					mayor=false;
				}
			}
		}mav.addObject("cursos",cursosOrdenados);}
		
		return mav;
	}

}
