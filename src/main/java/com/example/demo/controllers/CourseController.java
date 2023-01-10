package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Curso;
import com.example.demo.entity.Usuario;
import com.example.demo.model.ComentarioModel;
import com.example.demo.model.CursoModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.ComentarioService;
import com.example.demo.services.CursoService;
import com.example.demo.services.UsuarioService;

@Controller

public class CourseController {
	private static final String COURSES_VIEW = "cursos";
	private static final String ALUMNOS_VIEW = "alumnosCurso";
	private static final String FORM_VIEW = "formCurso";
	private static final String FORM_VIEWCOMENTARIO = "formComentario";

	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;

	@Autowired
	@Qualifier("userService")
	private UsuarioService userService;

	@Autowired
	@Qualifier("userRepository")
	public UserRepository userRepository;

	@Autowired
	@Qualifier("comentarioService")
	private ComentarioService comentarioService;

	@GetMapping("/admin/listCursos")
	public ModelAndView listCursos() {
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("cursos", cursoService.listAllCursos());
		return mav;
	}

	@GetMapping("/admin/listAlumnos/{id}")
	public ModelAndView listAlumnos(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ALUMNOS_VIEW);
		mav.addObject("alumnos", userService.listAlumnosByMatricula(id));
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

	@GetMapping("/alumno/formComentario/{id}")
	public String formComentario(@PathVariable(name = "id", required = false) Integer id, Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
	
			model.addAttribute("curso" ,id);
			model.addAttribute("comentario", new Comentario());
		
		return FORM_VIEWCOMENTARIO;
	}

}
