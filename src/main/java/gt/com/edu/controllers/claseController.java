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

import gt.com.edu.model.services.IClaseService;
import gt.com.edu.models.entity.Clase;

@RestController
@RequestMapping("/api/clases")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class claseController {
	
	@Autowired
	private IClaseService claseService;
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@GetMapping("/listar")
	public List<Clase> index(){
		return claseService.findAll();
	
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@GetMapping("/buscar/{id}")
	public Clase show(@PathVariable Long  id) {
		return claseService.findById(id);
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Clase create(@RequestBody Clase clase) {
		return claseService.save(clase);
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Clase update(@RequestBody Clase clase, @PathVariable Long id) {
		
		Clase claseActual=claseService.findById(id);
		
		claseActual.setId(clase.getId());
		claseActual.setDescripcion(clase.getDescripcion());
		
		return claseService.save(claseActual);
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
	claseService.delete(id);
		
		
		
	}

}
