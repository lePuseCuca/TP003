package dao;

import java.util.Map;

import model.Atraccion;

public interface AtraccionesDAO extends GenericDAO<Atraccion>{
	
	public abstract Atraccion findAtraccionById(String id);
	
	public abstract Map<String, Atraccion> findAllAtracciones();

	int updateStatus(Atraccion atr);

	public abstract Map<String, Atraccion> mapAll();
}