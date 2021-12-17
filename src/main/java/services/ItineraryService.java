package services;

import java.util.Map;

import dao.DAOFactory;
import dao.ItinerarioDAO;
import model.Itinerario;
import model.Producto;

public class ItineraryService {
	private ItinerarioDAO gestorItinerarios = DAOFactory.getItinerarioDAO();
	private Map<String, Producto> productos;
	
	public void setProductos(Map<String, Producto> productos) {
		this.productos = productos;
	}

	public Itinerario getItinerario(String nombreUsuario) {
		return this.gestorItinerarios.findItinerarioByUsuario(nombreUsuario, this.productos);
	}

	public void addProduct(Producto producto, String nombreUsuario) {
		Itinerario it = this.getItinerario(nombreUsuario);
		if (it == null) it = new Itinerario(nombreUsuario);
		it.addProducto(producto);
		this.gestorItinerarios.update(it);
	}
}
