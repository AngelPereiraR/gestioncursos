package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Usuario;
import com.example.demo.services.impl.UserService;

public class LoginController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	

	@GetMapping("/auth/registerForm")
	public String registerForm(Model model) {
		model.addAttribute("user", new Usuario());
	
		return "registro";
	}

	@PostMapping("/auth/register")
	public String register(@ModelAttribute Usuario usuario, RedirectAttributes flash) {
		userService.registrar(usuario);
		flash.addFlashAttribute("succes", "User registered succesfully!");
		return "redirect:/auth/login";
	}

}
