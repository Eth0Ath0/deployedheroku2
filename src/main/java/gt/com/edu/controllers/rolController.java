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

import gt.com.edu.model.services.IRolService;
import gt.com.edu.models.entity.Rol;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class rolController {
	
	@Autowired
	private IRolService rolService;
	@Secured("ROLE_ADMIN")
	@GetMapping("/listar")
	public List<Rol> index(){
		return rolService.findAll();
	
		
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/buscar/{id}")
	public Rol show(@PathVariable Long  id) {
		return rolService.findById(id);
		
	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Rol create(@RequestBody Rol rol) {
		return rolService.save(rol);
		
	}
	@Secured("ROLE_ADMIN")
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Rol update(@RequestBody Rol rol, @PathVariable Long id) {
		
		Rol rolActual=rolService.findById(id);
		
		rolActual.setId(rol.getId());
		rolActual.setNombre_rol(rol.getNombre_rol());
		
		return rolService.save(rolActual);
	}
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
	rolService.delete(id);
		
		
		
	}


}
