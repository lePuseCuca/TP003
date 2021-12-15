package services;

import java.util.List;

import model.Atraccion;
import model.ErrorDatosException;
import model.Tipo;
import dao.AtraccionesDAO;
import dao.DAOFactory;

public class AttractionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionesDAO().findAll();
	}

	public Atraccion create(String id, String nombre, double tiempo, double costo, int cupo, Tipo tipo,
			boolean disponible) throws ErrorDatosException {

		Atraccion atraccion = new Atraccion(id, nombre, tiempo, costo, cupo, tipo, disponible);

		// AQUI NO VALIDAMOS LO QUE INGRESA? SOLO EN EL CONSTRUCTOR?? if
		// (atraccion.isValid()) {
		AtraccionesDAO atraccionDAO = DAOFactory.getAtraccionesDAO();
		atraccionDAO.insert(atraccion);

		return atraccion;
	}

	public Atraccion update(String id, String nombre, double tiempo, double costo, int cupo, Tipo tipo,
			boolean disponible) {
		AtraccionesDAO atraccionDAO = DAOFactory.getAtraccionesDAO();

		Atraccion atraccion = atraccionDAO.findAtraccionById(id);

		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setTiempo(tiempo);
		atraccion.setCupo(cupo);

		// VALIDAMOS SI ES VALIDO? if (atraccion.isValid()) {
		atraccionDAO.update(atraccion);

		return atraccion;
	}

	// ESTA BIEN ESTE METODO?? LO MODIFIQUE ACA Y EN EL METODO DELETE

	public void delete(String id) {
		// Atraccion atraccion = new Atraccion(id, null, null, null, null, null, null);
		
		AtraccionesDAO atraccionDAO = DAOFactory.getAtraccionesDAO();
		Atraccion atraccion = atraccionDAO.findAtraccionById(id);
		
		atraccionDAO.delete(atraccion);
	}

	public Atraccion find(String id) {
		AtraccionesDAO atraccionDAO = DAOFactory.getAtraccionesDAO();
		return atraccionDAO.findAtraccionById(id);
	}

}
