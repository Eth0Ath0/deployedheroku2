package gt.com.edu.model.services;

import java.util.List;

import gt.com.edu.models.entity.Rol;



public interface IRolService {
	 //listar rol
		List<Rol> findAll();
		//buscar rol por id
		Rol findById(Long id);
	    //guardar rol
		Rol save(Rol rol);
	    //eliminar rol
		void delete(Long id);
	

}
