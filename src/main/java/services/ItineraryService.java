package services;

import java.util.Map;

import dao.DAOFactory;
import dao.ItinerarioDAO;
import model.Itinerario;
import model.Producto;

public class ItineraryService {
	private ItinerarioDAO gestorItinerarios = DAOFactory.getItinerarioDAO();
	private Map<String, Producto> productos;
	
	public ItineraryService(Map<String, Producto> productos) {
		this.productos = productos;
	}

	public Itinerario getItinerario(String parameter) {
		return this.gestorItinerarios.findItinerarioByUsuario(parameter, this.productos);
	}
}
