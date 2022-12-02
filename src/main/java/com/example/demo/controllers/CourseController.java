package com.example.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CourseController {
	private static final String LAYOUT_VIEW = "inicio";
	
	@PreAuthorize("hasAnyRole('alumno','profesor','administrador')")
	@GetMapping("/inicio/")
	private String home() {
		
		return LAYOUT_VIEW;
	}

}
