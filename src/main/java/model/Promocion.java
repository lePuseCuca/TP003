package model;

import java.util.List;

public class Promocion extends Producto{

	protected List<Atraccion> atracciones;
	private TipoPromocion tipoPromocion;
	
	public Promocion() {};
	
	public Promocion(String id, String nombre, TipoPromocion tipoPromo, List<Atraccion> atracciones, Tipo tipo, boolean disponible) {
		super(id, nombre, tipo);
		this.atracciones = atracciones;
		this.tiempo = setTiempo(atracciones);		
		this.tipoPromocion = tipoPromo;
		this.disponible = disponible;
	}
	
	public List<Atraccion> getAtracciones(){
		return this.atracciones;
	}
	
	public boolean getDisponible() {
		return this.disponible;
	}
	
	@Override
	public boolean esPromocion() {
		return true;
	}
	
	public TipoPromocion getTipoPromocion() {
		return this.tipoPromocion;
	}
	
	protected void setCosto() {
		double costoTotal = 0;
		for(Atraccion atr : atracciones)
			costoTotal += atr.getCosto();
		this.costo = costoTotal;
	}
	
	public boolean hayCupo() {
		for (Atraccion atr: atracciones)
			if (atr.getCupo() <= 0 )
				return false;
		return true;
	}
	
	private double setTiempo(List<Atraccion> atracciones) {
		double tiempoTotal = 0;		
		for (Atraccion at: atracciones)
			tiempoTotal += at.getTiempo();		
		return tiempoTotal;
	}

	@Override
	public boolean venderProducto() {
		boolean vendible = true;
		for (Atraccion atr: this.atracciones)
			if (atr.getCupo() == 0)
				vendible = false;
		if (vendible)
			for (Atraccion atr: this.atracciones)
				atr.restarCupo();
		return vendible;
	}	
	
		
	
}
