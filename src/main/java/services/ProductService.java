package services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.Atraccion;
import model.ComparadorProducto;
import model.Itinerario;
import model.Producto;
import model.Promocion;
import model.Usuario;

public class ProductService {
	
	private Map<String, Producto> productos = new HashMap<String, Producto>();

	public List<Producto> listForUser(Usuario usuario, Itinerario it, ComparadorProducto comparador) {

		List<Producto> productos = new LinkedList<Producto>();
		if (it == null) it = new Itinerario(usuario.getNombre());

		Iterator<Producto> itr = this.getProductsForUser(comparador).iterator();

		while (itr.hasNext()) {
			Producto producto = itr.next();
			if (!this.productBought(producto, it.getProductos())) {
				productos.add(producto);
			}
		}

		return productos;
	}

	/*
	 * Pre: productoId es un producto que no pertenese al itinerario del usuario.
	 * */
	public Map<String, String> buy(Usuario usuario, String productoId) {
		
		Map<String, String> errores = new HashMap<String, String>();
		Producto producto = this.productos.get(productoId);
				
		if (!producto.hayCupo()) {
			errores.put("producto", "No hay cupo disponible");
		} else if (usuario.getPresupuesto() < producto.getCosto()) {
			errores.put("user", "No tienes dinero suficiente");
		} else if (usuario.getTiempo() < producto.getTiempo()) {
			errores.put("user", "No tienes tiempo suficiente");
		}
		
		if (errores.isEmpty()) {
			producto.venderProducto();
			usuario.comprarProducto(producto);
		}
 	
		return errores;
	}
	
	public void setProductos(Map<String, Atraccion> atracciones, List<Promocion> promociones) {
		this.productos.putAll(atracciones);
		for (Promocion promo : promociones)
			this.productos.put(promo.getId(), promo);
	}
	
	public Map<String, Producto> getProductos() {
		return this.productos;
	}
	
	/*
	 * Recibe un usuario y devuelve una lista ordenada de productos según
	 * suspreferencias.
	 */
	public List<Producto> getProductsForUser(ComparadorProducto comp) {
		List<Producto> resultado = new LinkedList<Producto>(this.productos.values());
		Collections.sort(resultado, comp);
		return resultado;
	}
	
	public boolean productBought(Producto p, List<Producto> productosItinerario) {
		for (Producto producto : productosItinerario) {
			if (p.equals(producto)) return true;
			if (producto.esPromocion()) {
				for (Atraccion atr : producto.getAtracciones())
					if (p.equals(atr)) return true;
			}
		}
		return false;
	}
}
