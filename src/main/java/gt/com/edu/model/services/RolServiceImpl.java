package gt.com.edu.model.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.com.edu.models.dao.IRolDao;
import gt.com.edu.models.entity.Rol;

@Service
public class RolServiceImpl implements IRolService{
@Autowired
public IRolDao irolDao;

@Override
@Transactional(readOnly = true)
public List<Rol> findAll() {
	// TODO Auto-generated method stub
	return (List<Rol>) irolDao.findAll();
}

@Override
@Transactional(readOnly = true)
public Rol findById(Long id) {
	// TODO Auto-generated method stub
	return irolDao.findById(id).orElse(null);
}

@Override
public Rol save(Rol rol) {
	// TODO Auto-generated method stub
	return irolDao.save(rol);
}

@Override
public void delete(Long id) {
	// TODO Auto-generated method stub
	irolDao.deleteById(id);
}



}
