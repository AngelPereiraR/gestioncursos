package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CourseController {
	private static final String LAYOUT_VIEW = "inicio";

	@GetMapping("/inicio")
	public String firtsView() {
		return LAYOUT_VIEW;
	}

}
