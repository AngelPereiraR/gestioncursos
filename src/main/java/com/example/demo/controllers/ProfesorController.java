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

import com.example.demo.entity.Usuario;
import com.example.demo.model.UsuarioModel;
import com.example.demo.services.UsuarioService;

@Controller

public class ProfesorController {
	private static final String PROFESSORS_VIEW = "profesores";
	private static final String FORM_VIEW = "formProfesor";

	@Autowired
	@Qualifier("userService")
	public UsuarioService userService;

	@GetMapping("/admin/listaProfesores")
	public ModelAndView listaProfesores() {
		ModelAndView mav = new ModelAndView(PROFESSORS_VIEW);
		mav.addObject("profesores", userService.listAllProfesores());
		return mav;
	}

	@PostMapping("/admin/addProfesor")
	public String addCurso(@ModelAttribute("Profesor") UsuarioModel usuarioModel, RedirectAttributes flash) {
		if (usuarioModel.getId() == 0) {
			usuarioModel.setRole("ROLE_PROFESOR");
			userService.addProfesor((usuarioModel));

			flash.addFlashAttribute("succes", "professor added suff");
			return "redirect:/admin/listaProfesores";
		} else {
			userService.updateProfesor(usuarioModel);

			flash.addFlashAttribute("succes", "professor updated suff");
			return "redirect:/admin/listaProfesores";

		}

	}

	@PostMapping("/admin/removeProfesor/{id}")
	public String deleteCourse(@PathVariable("id") int id, RedirectAttributes flash) {
		userService.removeProfesor(id);

		flash.addFlashAttribute("succes", "profesor eliminado correctamente");
		return "redirect:/admin/listaProfesores";

	}

	@GetMapping(value = { "/admin/formProfesor/{id}", "/admin/formProfesor" })
	public String formCurso(@PathVariable(name = "id", required = false) Integer id, Model model) {

		if (id == null) {
			model.addAttribute("usuario", new Usuario());
		} else {
			model.addAttribute("usuario", userService.findProfesor(id));
		}
		return FORM_VIEW;
	}
}
