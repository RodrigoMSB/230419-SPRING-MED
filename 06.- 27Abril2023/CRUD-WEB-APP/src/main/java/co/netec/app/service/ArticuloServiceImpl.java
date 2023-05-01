package co.netec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import co.netec.app.dao.IArticuloDAO;
import co.netec.app.entities.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService {
	
	@Autowired
	private IArticuloDAO dao;

	@Override
	public List<Articulo> findAll() {
		
		return (List<Articulo>)dao.findAll();
	}

	@Override
	public Articulo findById(int id) {
		
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Articulo save(Articulo articulo) {
		
		return dao.save(articulo);
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		try {
			dao.deleteById(id);
		} catch(Exception ex) {
			// Mala practica, no hacer
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el artículo");
		}
		
	}

}
