package co.netec.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.netec.app.modelo.Alumno;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String iniciar(Model modelo) {
		
		Alumno alumno = new Alumno("Rodrigo", 37, "Ingeniero", "Bla bla bla ");
		
		modelo.addAttribute("alumno", alumno);
		
		return "inicio";
	}

}
