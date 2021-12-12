package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SecretariaTurismo {

	private Map<String, Atraccion> atracciones = new HashMap<String, Atraccion>();
	private List<Promocion> promociones = new LinkedList<Promocion>();
	private Map<String, Producto> productos = new HashMap<String, Producto>();

	public SecretariaTurismo(Map<String, Atraccion> atracciones, List<Promocion> promociones) {
		this.atracciones = atracciones;
		this.promociones = promociones;
		setProductos();
	}
	
	public List<Atraccion> getAtracciones() {
		List<Atraccion> resultado = new LinkedList<Atraccion>(this.atracciones.values());
		return resultado;
	}
	
	public List<Promocion> getPromociones() {
		return this.promociones;
	}
	
	private void setProductos() {
		this.productos.putAll(this.atracciones);
		for (Promocion promo : this.promociones)
			this.productos.put(promo.getId(), promo);
	}
	
	public Map<String, Producto> getProductos() {
		return productos;
	}
	
	/*
	 * Recibe un usuario y devuelve una lista ordenada de productos según
	 * suspreferencias.
	 */
	public List<Producto> getProductosParaUsuario(Usuario usr) {
		List<Producto> resultado = new LinkedList<Producto>(this.productos.values());
		Collections.sort(resultado, generarComparadorProducto(usr.getTipoPreferido()));
		return resultado;
	}
	
	public boolean atraccionComprada(Producto p, List<Producto> productosItinerario) {
		for (Producto producto : productosItinerario) {
			if (p.equals(producto)) return true;
			if (producto.esPromocion()) {
				for (Atraccion atr : producto.getAtracciones())
					if (p.equals(atr)) return true;
			}
		}
		return false;
	}

	private ComparadorProducto generarComparadorProducto(Tipo tipoPreferido) {
		List<Comparator<Producto>> comparadores = new LinkedList<Comparator<Producto>>();
		comparadores.add(new ComparadorTipoPreferido(tipoPreferido));
		comparadores.add(new ComparadorClase());
		comparadores.add(new ComparadorCosto());
		comparadores.add(new ComparadorTiempo());

		return (new ComparadorProducto(comparadores));
	}
}