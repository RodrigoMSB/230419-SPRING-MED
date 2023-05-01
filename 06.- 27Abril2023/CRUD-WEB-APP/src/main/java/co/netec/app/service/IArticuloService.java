package co.netec.app.service;

import java.util.List;

import co.netec.app.entities.Articulo;

public interface IArticuloService {
	
	public List<Articulo> findAll();
	
	public Articulo findById(int id);
	
	public Articulo save(Articulo articulo);
	
	public void delete(int id);

}
