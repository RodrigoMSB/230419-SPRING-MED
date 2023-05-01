package com.netec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.netec.app.entities.Articulo;
import com.netec.app.service.IArticuloService;

@Controller
public class HomeController {
	
	@Autowired
	private IArticuloService servicio;
	
	@GetMapping("/")
	public String inicio(Model model) {
		
		List<Articulo> listaArticulos = servicio.findAll();
		model.addAttribute("articulos", listaArticulos);
		
		return "listArticulos";
		
	}

}
