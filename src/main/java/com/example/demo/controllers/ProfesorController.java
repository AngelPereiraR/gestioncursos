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
import com.example.demo.repository.UserRepository;
import com.example.demo.services.impl.UsuarioServiceImp;

@Controller

public class ProfesorController {
	private static final String PROFESSORS_VIEW = "profesores";
	private static final String FORM_VIEW = "formProfesor";
	private static final String FORM_VIEW2 = "formProfesorUpdate";

	@Autowired
	@Qualifier("userService")
	public UsuarioServiceImp userService;

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
	public String addCurso(@ModelAttribute("Profesor") UsuarioModel usuarioModel, RedirectAttributes flash) {

		usuarioModel.setRole("ROLE_PROFESOR");
		userService.registrar(userService.transform(usuarioModel));

		flash.addFlashAttribute("succes", "professor added suff");
		return "redirect:/admin/listaProfesores";

	}

	@PostMapping("/profesor/updateProfesor")
	public String updateProfesor(@ModelAttribute("Profesor") UsuarioModel profesorModel, RedirectAttributes flash) {
		userService.updateProfesor(profesorModel);
		flash.addFlashAttribute("succes", "professor updated suff");
		return "redirect:/inicio/";
	}

	@GetMapping("/admin/removeProfesor/{id}")
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
			model.addAttribute("usuario", userService.findUsuario(id));
		}

		return FORM_VIEW;
	}

	@GetMapping("/profesor/formProfesorUpdate/{email}")
	public String formAlumno(@PathVariable(name = "email", required = false) String email, Model model) {
		model.addAttribute("profesor", userRepository.findByEmail(email));
		return FORM_VIEW2;
	}
}