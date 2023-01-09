package com.example.demo.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Usuario;
import com.example.demo.model.MatriculaModel;
import com.example.demo.model.Opcion;
import com.example.demo.model.UsuarioModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.CursoService;
import com.example.demo.services.MatriculaService;
import com.example.demo.services.NoticiaService;
import com.example.demo.services.UsuarioService;

@Controller
public class AlumnoController {
	private static final String ALUMNOS_VIEW = "alumnos";
	private static final String FORM_VIEW = "formAlumno";
	private static final String NOTICIAS_VIEW = "noticias";
	private static final String COURSES_VIEW = "cursosAlumno";


	@Autowired
	@Qualifier("userService")
	public UsuarioService userService;
	

	@Autowired
	@Qualifier("cursoService")
	public CursoService cursoService;
	@Autowired
	@Qualifier("userRepository")
	public UserRepository userRepository;
	
	@Autowired
	@Qualifier("noticiaService")
	private NoticiaService noticiaService;
	
	@Autowired
	@Qualifier("matriculaService")
	private MatriculaService matriculaService;
	
	

	@GetMapping("/admin/listaAlumnos")
	public ModelAndView listaAlumnos() {
		ModelAndView mav = new ModelAndView(ALUMNOS_VIEW);
		mav.addObject("alumnos", userService.listAllAlumnos());
		return mav;
	}

	@PostMapping("/alumno/updateAlumno")
	public String updateAlumno(@ModelAttribute("alumno") UsuarioModel alumnoModel, RedirectAttributes flash) {
		userService.updateAlumno(alumnoModel);

		flash.addFlashAttribute("success", "alumno actualizado correctamente");
		return "redirect:/inicio/";

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

	@GetMapping("/alumno/formAlumno")
	public String formAlumno(Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = userRepository.findByEmail(email);
		
		model.addAttribute("alumno", usuario);
		return FORM_VIEW;
	}
	
	@GetMapping("/alumno/listNoticias")
	public ModelAndView listNoticias() {
		ModelAndView mav = new ModelAndView(NOTICIAS_VIEW);
		mav.addObject("noticias", noticiaService.listAllNoticias());
		return mav;
	}
	
	@GetMapping("/alumno/listCursos")
	public String listCursos(@RequestParam(name = "name", required = false, defaultValue="") Opcion opcion, Model model) throws ParseException {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario user=userRepository.findByEmail(email);
		Calendar c1 = Calendar.getInstance();
		String fechaActual = ( Integer.toString(c1.get(Calendar.YEAR)) + "-" + Integer.toString(c1.get(Calendar.MONTH)+1) + "-" + Integer.toString(c1.get(Calendar.DATE))+" "+Integer.toString(c1.get(Calendar.HOUR_OF_DAY))+"OO:OO");
		List<MatriculaModel> matriculas= userService.listMatriculasAlumno(user);
		ArrayList<Integer> idcursos = new ArrayList<>();
		
		for(MatriculaModel m: matriculas) {
			idcursos.add(m.getIdcurso().getIdcurso());
		}
		model.addAttribute("fecha",fechaActual);
		model.addAttribute("matriculas",idcursos);
		if(opcion.getName().equals("basico")) {
		
			
			model.addAttribute("opcion",opcion);
			model.addAttribute("cursos", userService.listCursosAlumno(2));
			
		}else if(opcion.getName().equals("medio")) {
			model.addAttribute("opcion",opcion);
			model.addAttribute("cursos", userService.listCursosAlumno(6));
			
		}else if(opcion.getName().equals("avanzado")) {
		
			model.addAttribute("opcion",opcion);
			model.addAttribute("cursos",userService.listCursosAlumno(9));
			
		
		} else {
			model.addAttribute("opcion",opcion);
			model.addAttribute("cursos", cursoService.listAllCursos());
		}
		return COURSES_VIEW;
	}
	
}
