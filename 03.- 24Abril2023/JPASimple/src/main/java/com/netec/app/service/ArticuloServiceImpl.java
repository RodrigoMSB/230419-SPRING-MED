package com.netec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netec.app.dao.IArticuloDAO;
import com.netec.app.entities.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService {
	
	@Autowired
	private IArticuloDAO dao;
	
	@Override
	public List<Articulo> findAll() {
		
		List<Articulo> listaDeArticulos = (List<Articulo>)dao.findAll();
		
		return listaDeArticulos;
	}

}
