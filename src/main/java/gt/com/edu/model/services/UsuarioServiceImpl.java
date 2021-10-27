package gt.com.edu.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.IUsuarioDao;
import gt.com.edu.models.entity.Usuario;


@Service
public class UsuarioServiceImpl implements IUsuarioService {
@Autowired
    public IUsuarioDao iusuarioDao;

@Override
@Transactional(readOnly = true)
public List<Usuario> findAll() {
	// TODO Auto-generated method stub
	return (List<Usuario>) iusuarioDao.findAll();
}

@Override
@Transactional(readOnly = true)
public Usuario findById(Long id) {
	// TODO Auto-generated method stub
	return iusuarioDao.findById(id).orElse(null);
}

@Override
public Usuario save(Usuario usuario) {
	// TODO Auto-generated method stub
	return iusuarioDao.save(usuario);
}

@Override
public void delete(Long id) {
	// TODO Auto-generated method stub
	iusuarioDao.deleteById(id);
}

@Override
public Usuario findBynombre_usuario(String nombre_usuario) {
	// TODO Auto-generated method stub
	return null;
}
	
	
}
