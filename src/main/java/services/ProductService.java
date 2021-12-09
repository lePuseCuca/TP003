package services;

import java.util.Collections;
import java.util.Comparator;
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
import model.ComparadorClase;
import model.ComparadorCosto;
import model.ComparadorProducto;
import model.ComparadorTiempo;
import model.ComparadorTipoPreferido;
import model.Itinerario;
import model.Producto;
import model.Promocion;
import model.Tipo;
import model.Usuario;

public class ProductService {
	private Map<String, Atraccion> atracciones = new HashMap<String, Atraccion>();
	private List<Promocion> promociones = new LinkedList<Promocion>();
	private Map<String, Producto> productos = new HashMap<String, Producto>();
	private AtraccionesDAO gestorAtracciones = DAOFactory.getAtraccionesDAO();
	private PromocionDAO gestorPromociones = DAOFactory.getPromocionDAO();
	private ItinerarioDAO gestorItinerarios = DAOFactory.getItinerarioDAO();

	
	public ProductService() {
		this.atracciones = this.gestorAtracciones.findAllAtracciones();
		this.promociones = this.gestorPromociones.findAll(atracciones);
		setProductos();
	}

	private void setProductos() {
		this.productos.putAll(this.atracciones);
		for (Promocion promo : this.promociones)
			this.productos.put(promo.getNombre(), promo);
	}
	
	private ComparadorProducto generarComparadorProducto(Tipo tipoPreferido) {
		List<Comparator<Producto>> comparadores = new LinkedList<Comparator<Producto>>();
		comparadores.add(new ComparadorTipoPreferido(tipoPreferido));
		comparadores.add(new ComparadorClase());
		comparadores.add(new ComparadorCosto());
		comparadores.add(new ComparadorTiempo());

		return (new ComparadorProducto(comparadores));
	}
	
	//Este método debería ser responsabilidad del usuario --> Refactorizar class Usuario
	private boolean atraccionComprada(Producto p, List<Producto> productosItinerario) {
		for (Producto producto : productosItinerario) {
			if (p.equals(producto)) return true;
			if (producto.esPromocion()) {
				for (Atraccion atr : producto.getAtracciones())
					if (p.equals(atr)) return true;
			}
		}
		return false;
	}
	
	private List<Producto> getProductosParaUsuario(Usuario usuario) {
		List<Producto> resultado = new LinkedList<Producto>(this.productos.values());
		Collections.sort(resultado, generarComparadorProducto(usuario.getTipoPreferido()));
		return resultado;
	}
	
	public List<Producto> list(Usuario usuario) {
		List<Producto> productos = new LinkedList<Producto>();
		Itinerario itinerario = this.gestorItinerarios.findItinerarioByUsuario(usuario.getNombre(), this.productos);
		// 1° crear NullItinerario.java
		if (itinerario == null) itinerario = new Itinerario(usuario.getNombre());
		
		Iterator<Producto> itr = this.getProductosParaUsuario(usuario).iterator();
		
		while (itr.hasNext()) {
			Producto producto = itr.next();
			if (!atraccionComprada(producto, itinerario.getProductos())) {
				productos.add(producto);
			}
		}
		
		return productos;
	}

}
