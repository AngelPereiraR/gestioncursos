package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.UsuarioModel;
import com.example.demo.services.UsuarioService;

@Controller

public class ProfesorController {
	private static final String PROFESORES_VIEW = "profesores";

	@Autowired
	@Qualifier("userService")
	public UsuarioService userService;

	@GetMapping("/admin/listaProfesores")
	public ModelAndView listaProfesores() {
		ModelAndView mav = new ModelAndView(PROFESORES_VIEW);
		mav.addObject("profesores", userService.listAllProfesores());
		return mav;
	}

	@PostMapping("/admin/addProfesor")
	public String addCurso(@ModelAttribute("Profesor") UsuarioModel usuarioModel, RedirectAttributes flash) {
		if (usuarioModel.getId() == 0) {
			usuarioModel.setRole("ROLE_PROFESOR");
			userService.addProfesor((usuarioModel));

			flash.addFlashAttribute("succes", "course added suff");
			return "redirect:/admin/listCursos";
		} else {
			userService.updateProfesor(usuarioModel);

			flash.addFlashAttribute("succes", "course updated suff");
			return "redirect:/admin/listCursos";

		}

	}
}
