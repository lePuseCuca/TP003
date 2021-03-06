package services;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Atraccion;
import model.ErrorDatosException;
import model.Tipo;
import dao.AtraccionesDAO;
import dao.DAOFactory;

public class AttractionService {

	private AtraccionesDAO gestorAtracciones = DAOFactory.getAtraccionesDAO();
	
	public List<Atraccion> list() {
		return new LinkedList<Atraccion>(this.gestorAtracciones.mapAll().values());
	}
	
	public Map<String, Atraccion> map() {
		return this.gestorAtracciones.findAllAtracciones();
	}
	
	public Map<String, Atraccion> mapAll() {
		return this.gestorAtracciones.mapAll();
	}

	public int create(String id, String nombre, double tiempo, double costo, int cupo, Tipo tipo,
			boolean disponible) throws ErrorDatosException {
		Atraccion atraccion = new Atraccion(id, nombre, tiempo, costo, cupo, tipo, disponible);
		return this.gestorAtracciones.insert(atraccion);
	}
	
	public int update(String id, String nombre, double tiempo, double costo, int cupo, Tipo tipo,
			boolean disponible) throws ErrorDatosException {
		Atraccion atraccion = new Atraccion(id, nombre, tiempo, costo, cupo, tipo, disponible);
		return this.gestorAtracciones.update(atraccion);
	}
	
	public int update(Atraccion atraccion) {
		return this.gestorAtracciones.update(atraccion);
	}
	
	public int updateStatus(String id) {
		return this.gestorAtracciones.updateStatus(gestorAtracciones.findAtraccionById(id));
	}

	public int delete(String id) {
		return this.gestorAtracciones.delete(gestorAtracciones.findAtraccionById(id));
	}

	public Atraccion find(String id) {
		return this.gestorAtracciones.findAtraccionById(id);
	}

}
