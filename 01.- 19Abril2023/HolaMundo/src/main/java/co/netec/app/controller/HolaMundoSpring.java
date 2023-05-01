package co.netec.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.netec.app.modelo.Saludo;

@Controller
public class HolaMundoSpring {
	
	@GetMapping("/")
	public String saludar(Model modelo) {
		
		Saludo saludito = new Saludo("Hola Mundo Spring!!!!");
		
		modelo.addAttribute("saludito", saludito);
		
		return "holamundo";
	}

}
