package model;

import java.util.ArrayList;
import java.util.List;

public class PromocionAxB extends Promocion {
	
	private Atraccion atraccionSinCargo; 
	
	public PromocionAxB(){}
	
	public PromocionAxB(String id, String nombre, TipoPromocion tipoPromo, List<Atraccion> atracciones, Atraccion atraccionSinCargo, Tipo tipo, boolean disponible) {
		super(id, nombre, tipoPromo, atracciones, tipo, disponible);
		this.atraccionSinCargo = atraccionSinCargo;		
		this.tiempo += atraccionSinCargo.getTiempo();
		super.setCosto();
	}
	
	public String toString() {
		String detalle = String.format("%-32s %n",nombre);
		for (Atraccion atr: atracciones)
			detalle += "+" + atr; 
		detalle += String.format("+%-30s $%.0f \t %s hs. %n",atraccionSinCargo.getNombre() + " (SIN CARGO)", atraccionSinCargo.getCosto(), atraccionSinCargo.getTiempo());
		detalle += String.format("%30s \t$%.0f \t %s hs. %n", ">Subtotal:", this.getCosto(), tiempo);
		return detalle + "\n";
	}	
	
	@Override
	public List<Atraccion> getAtracciones(){
		List<Atraccion> temp = new ArrayList<Atraccion>(this.atracciones);
		temp.add(this.atraccionSinCargo);
		return temp;
	}
	
	@Override
	public boolean venderProducto() {
//		boolean vendido = true;
//		for (Atraccion atr: this.atracciones)
//			if (!atr.restarCupo())
//				vendido = false;
//		if(!this.atraccionSinCargo.restarCupo())
//			vendido = false;
//		
//		return vendido;
		return (super.venderProducto() && this.atraccionSinCargo.restarCupo());
	}

}
