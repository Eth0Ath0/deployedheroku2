package gt.com.edu.model.services;

import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import gt.com.edu.models.dao.IUsuarioDao;
import gt.com.edu.models.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService,UserDetailsService {
	

	
	//creamos un log en cuanto a los usuarios sean correctos o no
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	@Autowired
	private IUsuarioDao usuarioDao;
	@Override
	@Transactional(readOnly = true)
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario=usuarioDao.findBynombre_usuario(username);
		
		// preguntamos si el usuario es el correcto o no para pasarlo al log
		
		if(usuario==null) {
			logger.error("Error en el login, no existe el usuario '"+username+"' en el sistema");
			throw new UsernameNotFoundException("Error en el login, no existe el usuario '"+username+"' en el sistema");
		}
		
		//agregar roles de usuarios
		List<GrantedAuthority>authorities=usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre_rol()))
				.peek(autority -> logger.info("Role :"+ autority.getAuthority()))
				.collect(Collectors.toList());
		
		return new  User(usuario.getNombre_usuario(), usuario.getContraseña_usuario(),usuario.getEnabled(),true,true,true,authorities);
	}
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Usuario findBynombre_usuario(String nombre_usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
