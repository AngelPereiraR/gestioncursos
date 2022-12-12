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

import com.example.demo.entity.Noticia;
import com.example.demo.entity.Usuario;
import com.example.demo.model.NoticiaModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.NoticiaService;

@Controller
public class NoticiaController {
	private static final String NOTICIAS_VIEW = "noticias";
	private static final String FORM_VIEW = "formNoticia";

	@Autowired
	@Qualifier("noticiaService")
	private NoticiaService noticiaService;
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@GetMapping("/admin/listNoticias")
	public ModelAndView listNoticias() {
		ModelAndView mav = new ModelAndView(NOTICIAS_VIEW);
		mav.addObject("noticias", noticiaService.listAllNoticias());
		return mav;
	}

	@PostMapping("/admin/addNoticia/{email}")
	public String addNoticia(@PathVariable("email") String email, @ModelAttribute("noticia") NoticiaModel noticiaModel, RedirectAttributes flash) {
		if (noticiaModel.getIdnoticia() == 0) {
			Usuario usuario = userRepository.findByEmail(email);
			noticiaModel.setUsuario(usuario);
			noticiaService.addNoticia(noticiaModel);
			flash.addFlashAttribute("succes", "noticia added suff");
			return "redirect:/admin/listNoticias";
		} else {
			Usuario usuario = userRepository.findByEmail(email);
			noticiaModel.setUsuario(usuario);
			noticiaService.updateNoticia(noticiaModel);
			
			flash.addFlashAttribute("succes", "noticia updated suff");
			return "redirect:/admin/listNoticias";
		}
	}

	@GetMapping("/admin/removeNoticia/{id}")
	public String deleteNoticia(@PathVariable("id") int id, RedirectAttributes flash) {
		noticiaService.removeNoticia(id);

		flash.addFlashAttribute("succes", "noticia eliminada correctamente");
		return "redirect:/admin/listNoticias";
	}

	@GetMapping(value = { "/admin/formNoticia/{id}", "/admin/formNoticia" })
	public String formCurso(@PathVariable(name = "id", required = false) Integer id, Model model) {
		if (id == null) {
			model.addAttribute("noticia", new Noticia());
		} else {
			model.addAttribute("noticia", noticiaService.findNoticia(id));
		}
		return FORM_VIEW;
	}
}
