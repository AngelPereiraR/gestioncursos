package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.services.UsuarioService;

@Controller
@RequestMapping("/alumno")
public class UsuarioController {
	private static final String ALUMNOS_VIEW = "alumnos";

	@Autowired
	@Qualifier("userService")
	public UsuarioService userService;

	@GetMapping("/listaAlumnos")
	public ModelAndView listaAlumnos() {
		ModelAndView mav = new ModelAndView(ALUMNOS_VIEW);
		mav.addObject("alumnos", userService.listAllAlumnos());
		return mav;
	}
}
