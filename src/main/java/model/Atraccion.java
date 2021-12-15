package model;

import java.util.List;

public class Atraccion extends Producto {

	private int cupo;

	public Atraccion(String id, String nombre, double costo, double tiempo, int cupo, Tipo tipo) throws ErrorDatosException {

		super(id, nombre, tipo);
		if (validarDatoNumerico(costo) && validarDatoNumerico(tiempo) && validarDatoNumerico(cupo)) {
			this.costo = costo;
			this.tiempo = tiempo;
			this.cupo = cupo;
		}else
			throw new ErrorDatosException("Datos con valor negativo");

	}

	public int getCupo() {
		return this.cupo;
	}

	@Override
	public String toString() {
		return String.format("%-30s $%.0f \t %s hs. %n", nombre + " [" + tipo.getDescripcion() + "]", costo, tiempo);
	}

	public boolean restarCupo() {
		if (this.hayCupo()) {
			this.cupo -= 1;
			return true;
		}
		return false;
	}

	public boolean hayCupo() {
		return this.getCupo() > 0;
	}

	@Override
	public List<Atraccion> getAtracciones() {
		return null;
	}
	

	@Override
	public boolean venderProducto() {
		return this.restarCupo();
	}

}
