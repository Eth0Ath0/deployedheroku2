package gt.com.edu.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import gt.com.edu.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	@Query("select u from Usuario u where  u.nombre_usuario=?1" )
	public Usuario findBynombre_usuario(String nombre_usuario);

}
