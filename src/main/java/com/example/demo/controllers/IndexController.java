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
import com.example.demo.repository.UserRepository;
import com.example.demo.services.CursoService;
import com.example.demo.services.NoticiaService;
import com.example.demo.services.UsuarioService;

@Controller

public class IndexController {
	private static final String LAYOUT_VIEW = "inicio";


	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;
	
	@Autowired
	@Qualifier("userService")
	private UsuarioService userService;

	@Autowired
	@Qualifier("noticiaService")
	private NoticiaService noticiaService;
	

	@GetMapping("/inicio/")
	private ModelAndView home() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Usuario usuario = userService.findByEmail(email);
		ModelAndView mav = new ModelAndView(LAYOUT_VIEW);
		if(usuario.getRole().equalsIgnoreCase("ROLE_ALUMNO")) {
		
			
		mav.addObject("noticias", noticiaService.listAllOrderNoticias());}
		return mav;
	}

	
}
