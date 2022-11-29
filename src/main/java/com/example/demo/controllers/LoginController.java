package com.example.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Usuario;

public class LoginController {

	@GetMapping("/auth/registerForm")
	public String registerForm(Model model) {
		model.addAttribute("user", new Usuario());
		return "registro";
	}

	@PostMapping("/auth/register")
	public String register(@ModelAttribute Usuario usuario, RedirectAttributes flash) {
		//usuarioService.registrar(usuario);
		flash.addFlashAttribute("succes", "User registered succesfully!");
		return "redirect:/auth/login";
	}

}
