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
import gt.com.edu.model.services.IAulaService;
import gt.com.edu.models.entity.Aula;



@RestController
@RequestMapping("/api/aulas")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class aulaController {
	@Autowired
	private IAulaService aulaService;
	
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@GetMapping("/listar")
	public List<Aula> index(){
		return aulaService.findAll();
	
		
	}
	
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@GetMapping("/buscar/{id}")
	public Aula show(@PathVariable Long  id) {
		return aulaService.findById(id);
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Aula create(@RequestBody Aula aula) {
		return aulaService.save(aula);
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Aula update(@RequestBody Aula aula, @PathVariable Long id) {
		
		
		Aula aulaActual=aulaService.findById(id);
		
		aulaActual.setId_aula(aula.getId_aula());
		aulaActual.setCapacidad_aula(aula.getCapacidad_aula());
		aulaActual.setNombre_aula(aula.getNombre_aula());
		aulaActual.setSeccion_aula(aula.getSeccion_aula());
		
		return aulaService.save(aulaActual);
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
    aulaService.delete(id);
		
		
		
	}

}
