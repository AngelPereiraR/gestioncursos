package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gestion")
public class CourseController {
	private static final String LAYOUT_VIEW = "index";

	@GetMapping("/hola")
	public String firtsView() {
		return LAYOUT_VIEW;
	}

}
