package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Usuario;
import com.example.demo.services.impl.UsuarioServiceImp;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("userService")
	private UsuarioServiceImp userService;

	@GetMapping("/auth/login")
	public String login(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "login";
	}

	@GetMapping("/auth/registerForm")
	public String registerForm(Model model) {
		model.addAttribute("alumno", new Usuario());

		return "registro";
	}

	@PostMapping("/auth/register")
	public String register(@ModelAttribute Usuario user, RedirectAttributes flash) {
		user.setRole("ROLE_ALUMNO");
		userService.registrar(user);
		flash.addFlashAttribute("succes", "User registered succesfully!");
		return "redirect:/auth/login";
	}

}