package co.netec.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.netec.app.dao.IAlumnoDAO;
import co.netec.app.entities.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private IAlumnoDAO dao;
	
	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		
		Alumno alumn = dao.save(alumno);
		
		return alumn;
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		
		return (List<Alumno>)dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findById(Integer id) {
		
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		
		dao.deleteById(id);

		return true;
	}

	@Override
	@Transactional
	public Alumno update(Alumno alumno) {
		
		Optional<Alumno> alumnoBD = dao.findById(alumno.getId());
		
		if (alumnoBD.isPresent()) {
			
			Alumno alumnoActualizar = alumnoBD.get();
			
			alumnoActualizar.setNombre(alumno.getNombre());
			alumnoActualizar.setEdad(alumno.getEdad());
			alumnoActualizar.setCorreo(alumno.getCorreo());
			
			return save(alumnoActualizar);
			
		}
		
		return null;
	}

}
