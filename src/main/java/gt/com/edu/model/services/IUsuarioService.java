package gt.com.edu.model.services;

import java.util.List;

import gt.com.edu.models.entity.Usuario;

public interface IUsuarioService {

	        //listar usuario
			List<Usuario> findAll();
			//buscar usuario por id
			Usuario findById(Long id);
		    //guardar usuario 
			Usuario save(Usuario usuario);
		    //eliminar aula
			void delete(Long id);
			
			public Usuario findBynombre_usuario(String nombre_usuario);
}
