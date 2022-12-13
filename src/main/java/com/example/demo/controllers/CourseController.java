package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Curso;
import com.example.demo.model.CursoModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.CursoService;
import com.example.demo.services.UsuarioService;

@Controller

public class CourseController {
	private static final String LAYOUT_VIEW = "inicio";
	private static final String COURSES_VIEW = "cursos";
	private static final String FORM_VIEW = "formCurso";

	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;
	
	@Autowired
	@Qualifier("userService")
	private UsuarioService userService;
	
	@Autowired
	@Qualifier("userRepository")
	public UserRepository userRepository;

	

	@GetMapping("/admin/listCursos")
	public ModelAndView listCursos() {
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("cursos", cursoService.listAllCursos());
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

		if (id == null) {
			model.addAttribute("curso", new Curso());
		} else {
			model.addAttribute("curso", cursoService.findCurso(id));
		}
		return FORM_VIEW;
	}

}
