package co.netec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.netec.app.entities.Alumno;
import co.netec.app.service.IAlumnoService;

@RestController
public class AlumnoController {
	
	@Autowired
	private IAlumnoService servicio;
	
	@PostMapping("/alumno")
	public Alumno salvar(@RequestBody Alumno alumno) {
		
		Alumno alumn = servicio.save(alumno);
		
		return alumn;
		
	}
	
	
	@GetMapping("/listar")
	public List<Alumno> listar() {
		
		return servicio.findAll();
	}
	
	
	@GetMapping("/alumno/{id}")
	public Alumno buscarPorId(@PathVariable Integer id) {
		
		return servicio.findById(id);
	}
	
	
	@DeleteMapping("/alumno/delete/{id}")
	public ResponseEntity<Void> eliminarAlumno(@PathVariable("id") Integer id) {
		
		servicio.delete(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/alumno/update")
	public ResponseEntity<Alumno> actualizarAlumno(@RequestBody Alumno alumn) {
		
		Alumno alumnoActualizado = servicio.update(alumn);
		
		if (alumnoActualizado != null) {
			
			return new ResponseEntity(alumnoActualizado, HttpStatus.OK);
			
		}
		
		return ResponseEntity.notFound().build();
		
	}

}
