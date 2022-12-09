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
import com.example.demo.services.UsuarioService;

@Controller
public class AlumnoController {
	private static final String ALUMNOS_VIEW = "alumnos";

	@Autowired
	@Qualifier("userService")
	public UsuarioService userService;

	@GetMapping("/admin/listaAlumnos")
	public ModelAndView listaAlumnos() {
		ModelAndView mav = new ModelAndView(ALUMNOS_VIEW);
		mav.addObject("alumnos", userService.listAllAlumnos());
		return mav;
	}
	
	@PostMapping("/admin/updateAlumno")
	public String updateAlumno(@ModelAttribute("alumno") UsuarioModel alumnoModel, RedirectAttributes flash) {
		userService.updateAlumno(alumnoModel);
			
		flash.addFlashAttribute("success", "alumno actualizado correctamente");
		return "redirect:/admin/listaAlumnos";
		
	}
	
	@GetMapping("/admin/removeAlumno/{id}")
	public String deleteAlumno(@PathVariable("id") int id, RedirectAttributes flash) {
		userService.removeAlumno(id);
		
		flash.addFlashAttribute("success", "alumno eliminado correctamente");
		return "redirect:/admin/listaAlumnos";
		
	}
	
	@GetMapping("/admin/activateAlumno/{id}")
	public String activateAlumno(@PathVariable("id") int id, RedirectAttributes flash) {
		userService.activateAlumno(id);
		
		flash.addFlashAttribute("success", "alumno activado correctamente");
		return "redirect:/admin/listaAlumnos";
		
	}
	
	@GetMapping("/admin/deactivateAlumno/{id}")
	public String deactivateAlumno(@PathVariable("id") int id, RedirectAttributes flash) {
		userService.deactivateAlumno(id);
		
		flash.addFlashAttribute("success", "alumno desactivado correctamente");
		return "redirect:/admin/listaAlumnos";
		
	}
}
