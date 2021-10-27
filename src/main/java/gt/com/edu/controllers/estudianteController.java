package gt.com.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gt.com.edu.model.services.IEstudianteService;
import gt.com.edu.models.entity.Estudiante;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins={"http://localhost:4200","*"})
//@CrossOrigin(origins={"http"})
public class estudianteController {

	@Autowired
	private IEstudianteService estudianteservice;
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@GetMapping("/listar")
	public List<Estudiante> index(){
		return estudianteservice.findAll();
	
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@GetMapping("/buscar/{id}")
	public Estudiante show(@PathVariable String  id) {
		return estudianteservice.findById(id);
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Estudiante create(@RequestBody Estudiante estudiante) {
		return estudianteservice.save(estudiante);
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Estudiante update(@RequestBody Estudiante estudiante, @PathVariable String id) {
		
		Estudiante estudianteActual=estudianteservice.findById(id);
		estudianteActual.setCodigo_personal(estudiante.getCodigo_personal());
		estudianteActual.setPrimer_nombre_estudiante(estudiante.getPrimer_nombre_estudiante());
		estudianteActual.setSegundo_nombre_estudiante(estudiante.getPrimer_nombre_estudiante());
		estudianteActual.setPrimer_apellido_estudiante(estudiante.getPrimer_apellido_estudiante());
		estudianteActual.setSegundo_apellido_estudiante(estudiante.getSegundo_apellido_estudiante());
		estudianteActual.setDireccion_estudiante(estudiante.getDireccion_estudiante());
		estudianteActual.setEdad_estudiante(estudiante.getEdad_estudiante());
		estudianteActual.setFecha_nacimiento(estudiante.getFecha_nacimiento());
		estudianteActual.setIdioma_estudiante(estudiante.getIdioma_estudiante());
		estudianteActual.setLateralidad_estudiante(estudiante.getLateralidad_estudiante());
		estudianteActual.setObservacion(estudiante.getObservacion());
		estudianteActual.setSexo_estudiante(estudiante.getSexo_estudiante());
		return estudianteservice.save(estudianteActual);
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		estudianteservice.delete(id);
		
		
		
	}

}
