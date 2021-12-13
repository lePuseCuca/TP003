package services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dao.AtraccionesDAO;
import dao.DAOFactory;
import dao.ItinerarioDAO;
import dao.PromocionDAO;
import model.Atraccion;
import model.Itinerario;
import model.Producto;
import model.Promocion;
import model.SecretariaTurismo;
import model.Usuario;

public class ProductService {

	private AtraccionesDAO gestorAtracciones = DAOFactory.getAtraccionesDAO();
	private PromocionDAO gestorPromociones = DAOFactory.getPromocionDAO();
	private ItinerarioDAO gestorItinerarios = DAOFactory.getItinerarioDAO();
	private SecretariaTurismo st;

	public ProductService() {
		this.st = new SecretariaTurismo(this.gestorAtracciones.findAllAtracciones(),
				this.gestorPromociones.findAll(this.gestorAtracciones.findAllAtracciones()));
	}

	// Refactorizar nombre de variables!
	public List<Producto> list(Usuario usuario) {

		List<Producto> productos = new LinkedList<Producto>();
		Itinerario itinerario = this.gestorItinerarios.findItinerarioByUsuario(usuario.getNombre(), st.getProductos());
		// 1° crear NullItinerario.java
		if (itinerario == null)
			itinerario = new Itinerario(usuario.getNombre());

		Iterator<Producto> itr = st.getProductosParaUsuario(usuario).iterator();

		while (itr.hasNext()) {
			Producto producto = itr.next();
			if (!st.atraccionComprada(producto, itinerario.getProductos())) {
				productos.add(producto);
			}
		}

		return productos;
	}

	public List<Promocion> promotionslist() {
		return st.getPromociones();
	}

	public List<Atraccion> attractionslist() {
		return st.getAtracciones();
	}

	public Map<String, String> buy(Usuario usuario, String productoId) {
		
		Map<String, String> errores = new HashMap<String, String>();
		Producto producto = st.getProductos().get(productoId);
		UserService userService = new UserService();
		
		if (!producto.hayCupo()) {
			errores.put("producto", "No hay cupo disponible");
		} else if (usuario.getPresupuesto() < producto.getCosto()) {
			errores.put("user", "No tienes dinero suficiente");
		} else if (usuario.getTiempo() < producto.getTiempo()) {
			errores.put("user", "No tienes tiempo suficiente");
		}
		
		if (errores.isEmpty()) {
			producto.venderProducto();
			this.gestorItinerarios.update(
					this.gestorItinerarios.findItinerarioByUsuario(usuario.getNombre(), st.getProductos()));
			usuario.comprarProducto(producto);
			userService.update(usuario);
			
			if (producto.esPromocion()) {
				this.gestorPromociones.update((Promocion) producto);
			} else {
				this.gestorAtracciones.update((Atraccion) producto);
			}
		}
 	
		return errores;
	}
}
