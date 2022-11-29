package com.example.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Usuario;

public class LoginController {
	
	@GetMapping("/auth/registerForm")
	public String registerForm(Model model) {
		model.addAttribute("user", new Usuario());
		return "registro";
	}
	
	

}
