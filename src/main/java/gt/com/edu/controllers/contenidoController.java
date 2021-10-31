package gt.com.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gt.com.edu.model.services.IClaseService;
import gt.com.edu.model.services.IContenidoService;
import gt.com.edu.models.entity.Clase;
import gt.com.edu.models.entity.Contenido;
import gt.com.edu.model.services.StorageService;

@RestController
@RequestMapping("/api/contenidos")
@CrossOrigin(origins={"http://localhost:4200","*"})
public class contenidoController {
	
	@Autowired
	private IContenidoService contenidoService;
	
	@Autowired
	private StorageService service;
	
	@Autowired
	private IClaseService claseService;
	
	
	@GetMapping("/listar")
	public List<Contenido> index(){
		return contenidoService.findAll();
	
		
	}
	

	@GetMapping("/buscar/{id}")
	public Contenido show(@PathVariable Long  id) {
		return contenidoService.findById(id);
		
	}
	/*@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Contenido create(@RequestBody Contenido contenido) {
		return contenidoService.save(contenido);
		
	}*/
	
	//cargar un archivo al bucket AWS
	    @Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
		@PostMapping("/upload")
		public ResponseEntity<String> uploadFile(@RequestParam( value ="file") MultipartFile file, @RequestParam("id_clase")String id_clase) {
			
	    	Clase clase= claseService.findById(Long.parseLong(id_clase));
	    	String nombreArchivo=service.uploadFile(file);
	    	
	    	Contenido contenido=new Contenido();
	    	contenido.setNombre_contenido(nombreArchivo);
	    	contenido.setClase(clase);
	    	
	    	contenidoService.save(contenido);
	    	
 			return new ResponseEntity<>(contenido.getNombre_contenido(), HttpStatus.OK);
		}
	
	
	
	
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@PutMapping("/actualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Contenido update(@RequestBody Contenido contenido, @PathVariable Long id) {
		
		
		Contenido contenidoActual=contenidoService.findById(id);
		
		contenidoActual.setId(contenido.getId());
		contenidoActual.setNombre_contenido(contenido.getNombre_contenido());
		contenidoActual.setFecha_creacion(contenido.getFecha_creacion());
			
		return contenidoService.save(contenidoActual);
	}
	
	
	
	//descarga archivo del bucket AWS
	    @Secured({"ROLE_PROFESOR","ROLE_ADMIN","ROLE_ESTUDIANTE"})
		@GetMapping("/download/{fileName}")
		public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName){
			
		byte[] data=service.downloadFile(fileName);
		ByteArrayResource resource= new ByteArrayResource(data);
		return ResponseEntity
	            .ok()
	            .contentLength(data.length)
	            .header("Content-type", "application/octet-stream")
	            .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
	            .body(resource);	
			
		}
	
	
	
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
    contenidoService.delete(id);
				
	}
	
	 // eliminar archivo del bucket AWS
	@Secured({"ROLE_PROFESOR","ROLE_ADMIN"})
    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
    }
	
	

}
