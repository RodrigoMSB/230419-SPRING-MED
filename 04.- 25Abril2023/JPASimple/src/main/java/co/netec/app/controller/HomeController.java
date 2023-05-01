package co.netec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.netec.app.entities.Articulo;
import co.netec.app.service.IArticuloService;

@Controller
public class HomeController {
	
	@Autowired
	private IArticuloService servicio;
	
	@GetMapping("/")
	public String iniciar(Model modelo) {
		
		List<Articulo> lista = servicio.findAll();
		
		modelo.addAttribute("articulos", lista);
		
		return "listArticulos";
		
	}

}
