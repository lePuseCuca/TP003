package model;

import java.util.List;

public class PromocionAbsoluta extends Promocion{
	public PromocionAbsoluta() {}
	
	public PromocionAbsoluta(String id, String nombre, TipoPromocion tipoPromo, List<Atraccion> atracciones, Tipo tipo, double costo, boolean disponible) throws ErrorDatosException {
		super(id, nombre, tipoPromo, atracciones, tipo, disponible);
		if(validarDatoNumerico(costo))
			this.costo = costo;
		else
			throw new ErrorDatosException("Datos con valor negativo");
	}
	
	@Override
	public String toString() {
		String detalle = String.format("%-32s %n",nombre);
		for (Atraccion atr: atracciones)
			detalle += "+" + atr; 
		detalle += String.format("%32s$%.0f \t %s hs. %n", ">Subtotal: ", this.getCosto(), tiempo);
		return detalle + "\n";			
	}

}
