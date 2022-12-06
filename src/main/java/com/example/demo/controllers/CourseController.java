package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.entity.Curso;

import com.example.demo.model.CursoModel;

import com.example.demo.services.CursoService;

@Controller

public class CourseController {
	private static final String LAYOUT_VIEW = "inicio";
	private static final String COURSES_VIEW="cursos";
	private static final String FORM_VIEW="formCurso";
	
	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;
	
	
	@PreAuthorize("hasAnyRole('alumno','profesor','administrador')")
	@GetMapping("/inicio/")
	private String home() {
		
		return LAYOUT_VIEW;
	}
	
	@PreAuthorize("hasRole('administrador')")
	@GetMapping("/admin/listCursos")
	public ModelAndView listCursos() {
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("cursos",cursoService.listAllCursos());
		return mav;
	}
	
	
	@PreAuthorize("hasRole('administrador')")
	@PostMapping("/admin/addCurso")
	public String addCurso(@ModelAttribute("curso") CursoModel cursoModel, RedirectAttributes flash) {
		if(cursoModel.getIdcurso()==0) {
		cursoService.addCurso(cursoModel);
		
		flash.addFlashAttribute("succes", "course added suff");
		return "redirect:/admin/listCursos";
		}
		else {
			cursoService.updateCurso(cursoModel);
			
			flash.addFlashAttribute("succes", "course updated suff");
			return "redirect:/admin/listCursos";
			
		}
		
	}
	
	
	@PreAuthorize("hasRole('administrador')")
	@PostMapping("/admin/removeCurso/{id}")
	public String deleteCourse(@PathVariable("id") int id, RedirectAttributes flash) {
		cursoService.removeCurso(id);
		
		flash.addFlashAttribute("succes", "curso eliminado correctamente");
		return "redirect:/admin/listCursos";
		
	}
	@PreAuthorize("hasRole('administrador')")
	@GetMapping( value={"/admin/formCurso/{id}" ,"/admin/formCurso"})
	public String formCurso(@PathVariable(name="id", required=false) Integer id,Model model) {
		
		
		if(id==null) {
		model.addAttribute("curso",new Curso());
		}else {
			model.addAttribute("curso",cursoService.findCurso(id));
		}
		return FORM_VIEW;
	}
	
	
	

}
