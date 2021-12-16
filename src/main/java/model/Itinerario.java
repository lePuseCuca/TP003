package model;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {
	private String idUsuario;
	private List<Producto> productos;
		
	public Itinerario (String idUsuario) {
		this.idUsuario = idUsuario;
		this.productos = new ArrayList<Producto>();
	}
	
	public void addProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public int getTotalProductos() {
		return this.productos.size();
	}
	
	public String getNombreUsuario () {
		return this.idUsuario;
	}
	
	public double getTiempo() {
		return this.calcularTiempoItinerario();
	}
	public double getCosto() {
		return this.calcularCostoItinerario();
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}

	@Override
	public String toString() {
		String resumen = "";
		if (this.productos.size() > 0) {
			resumen += "+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
						"Itinerario para " + this.idUsuario + "\n";
			
			for (Producto prd : this.productos) resumen += prd.toString();
			
			resumen += "COSTO TOTAL: $" + String.format("%.0f", calcularCostoItinerario()) + " - Tiempo necesario: "
					+ calcularTiempoItinerario() + " hs.\n" +
					"+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
			
		} else {
			
			resumen += "+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
					this.idUsuario + ", tu itinerario esta vacio.\n" +
					"+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
		}
		return resumen;
	}

	private double calcularCostoItinerario() {
		double costoItinerario = 0;
		if (this.productos != null) {
			for (Producto compra : this.productos)
				costoItinerario += compra.getCosto();
		}
		return costoItinerario;
	}

	private double calcularTiempoItinerario() {
		double tiempoItinerario = 0;
		if (this.productos != null) {
			for (Producto compra : this.productos)
				tiempoItinerario += compra.getTiempo();
		}
		return tiempoItinerario;
	}
}