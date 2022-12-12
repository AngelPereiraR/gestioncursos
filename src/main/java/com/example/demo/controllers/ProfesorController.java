package com.example.demo.controllers;

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

import com.example.demo.entity.Curso;
import com.example.demo.entity.Usuario;
import com.example.demo.model.CursoModel;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.CursoService;
import com.example.demo.services.impl.UsuarioServiceImp;

@Controller

public class ProfesorController {
	private static final String PROFESSORS_VIEW = "profesores";
	private static final String FORM_VIEW = "formProfesor";
	private static final String FORM_VIEW2 = "formProfesorUpdate";
	
	private static final String COURSES_VIEW = "cursosProfesor";
	private static final String FORMCURSO_VIEW = "formCurso";

	@Autowired
	@Qualifier("userService")
	public UsuarioServiceImp userService;
	
	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;


	@Autowired
	@Qualifier("userRepository")
	public UserRepository userRepository;

	@GetMapping("/admin/listaProfesores")
	public ModelAndView listaProfesores() {
		ModelAndView mav = new ModelAndView(PROFESSORS_VIEW);
		mav.addObject("profesores", userService.listAllProfesores());
		return mav;
	}

	@PostMapping("/admin/addProfesor")
	public String addProfesor(@ModelAttribute("Profesor") UsuarioModel usuarioModel, RedirectAttributes flash) {
		if (usuarioModel.getId() == 0) {
		usuarioModel.setRole("ROLE_PROFESOR");
		userService.registrar(userService.transform(usuarioModel));

		flash.addFlashAttribute("succes", "profesor añadido satisfactoriamente");
		}else {
			userService.updateProfesor(usuarioModel);

			flash.addFlashAttribute("succes", "profesor editado satisfactoriamente");
			return "redirect:/admin/listCursos";

		}
		return "redirect:/admin/listaProfesores";
		

	}

	@PostMapping("/profesor/updateProfesor")
	public String updateProfesor(@ModelAttribute("Profesor") UsuarioModel profesorModel, RedirectAttributes flash) {
		userService.updateProfesor(profesorModel);
		flash.addFlashAttribute("succes", "professor updated suff");
		return "redirect:/inicio/";
	}

	@GetMapping("/admin/removeProfesor/{id}")
	public String deleteProfesor(@PathVariable("id") int id, RedirectAttributes flash) {
		userService.removeProfesor(id);

		flash.addFlashAttribute("succes", "profesor eliminado correctamente");
		return "redirect:/admin/listaProfesores";

	}

	@GetMapping(value = { "/admin/formProfesor/{id}", "/admin/formProfesor" })
	public String formProfesor(@PathVariable(name = "id", required = false) Integer id, Model model) {

		if (id == null) {
			model.addAttribute("usuario", new Usuario());
		} else {
			model.addAttribute("usuario", userService.findUsuario(id));
		}

		return FORM_VIEW;
	}

	@GetMapping("/profesor/formProfesorUpdate")
	public String formProfesorUpdate( Model model) {
	String email=SecurityContextHolder.getContext().getAuthentication().getName();
		
		
		model.addAttribute("profesor", userRepository.findByEmail(email));
		return FORM_VIEW2;
	}
	
	@GetMapping("/profesor/listCursos")
	public String listCursos(Model model) {
		String email=SecurityContextHolder.getContext().getAuthentication().getName();
	
		Usuario profesor = userRepository.findByEmail(email);
		
		model.addAttribute("cursos", userService.listAllCursos(userService.transform(profesor)));
		return COURSES_VIEW;
	}

	@PostMapping("/profesor/addCurso")
	public String addCurso(@ModelAttribute("curso") CursoModel cursoModel, RedirectAttributes flash) {
		
		String email=SecurityContextHolder.getContext().getAuthentication().getName();
		
		Usuario profesor = userRepository.findByEmail(email);
		if (cursoModel.getIdcurso() == 0) {
			
			cursoModel.setIdprofesor(profesor);
			cursoService.addCurso(cursoModel);
			flash.addFlashAttribute("succes", "course added suff");
			return "redirect:/profesor/listCursos";
		} else {
			cursoService.updateCurso(cursoModel);

			flash.addFlashAttribute("succes", "course updated suff");
			return "redirect:/profesor/listCursos";

		}

	}

	@GetMapping("/profesor/removeCurso/{id}")
	public String deleteCourse(@PathVariable("id") int id, RedirectAttributes flash) {
		cursoService.removeCurso(id);

		flash.addFlashAttribute("succes", "curso eliminado correctamente");
		return "redirect:/profesor/listCursos";

	}

	@GetMapping(value = { "/profesor/formCurso/{id}", "/profesor/formCurso" })
	public String formCurso(@PathVariable(name = "id", required = false) Integer id, Model model) {

		if (id == null) {
			model.addAttribute("curso", new Curso());
		} else {
			model.addAttribute("curso", cursoService.findCurso(id));
		}
		return FORMCURSO_VIEW;
	}
}