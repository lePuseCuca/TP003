package services;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import model.ComparadorClase;
import model.ComparadorCosto;
import model.ComparadorProducto;
import model.ComparadorTiempo;
import model.ComparadorTipoPreferido;
import model.Producto;
import model.Tipo;

public class ComparatorService {
	
	public ComparadorProducto generarComparadorProducto(Tipo tipoPreferido) {
		List<Comparator<Producto>> comparadores = new LinkedList<Comparator<Producto>>();
		comparadores.add(new ComparadorTipoPreferido(tipoPreferido));
		comparadores.add(new ComparadorClase());
		comparadores.add(new ComparadorCosto());
		comparadores.add(new ComparadorTiempo());

		return (new ComparadorProducto(comparadores));
	}
	
}
