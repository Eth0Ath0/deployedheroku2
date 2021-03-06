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

import gt.com.edu.model.services.IGradoService;
import gt.com.edu.models.entity.Grado;



@RestController
@RequestMapping("/api/grados")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class gradoController {
	
	@Autowired
	private IGradoService gradoService;
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@GetMapping("/listar")
	public List<Grado> index(){
		return gradoService.findAll();
	
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@GetMapping("/buscar/{id}")
	public Grado show(@PathVariable Long  id) {
		return gradoService.findById(id);
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Grado create(@RequestBody Grado grado) {
		return gradoService.save(grado);
		
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Grado update(@RequestBody Grado grado, @PathVariable Long id) {
		
		Grado gradoActual=gradoService.findById(id);
		
		gradoActual.setId_grado(grado.getId_grado());
		gradoActual.setNombre_grado(grado.getNombre_grado());
			
		return gradoService.save(gradoActual);
	}
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
	gradoService.delete(id);
		
		
		
	}


}
