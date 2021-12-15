package model;

import java.util.List;

public class Atraccion extends Producto {

	private int cupo;
	private boolean disponible;

	public Atraccion(String id, String nombre, double tiempo, double costo, int cupo, Tipo tipo, boolean disponible)
			throws ErrorDatosException {

		super(id, nombre, tipo);
		if (validarDatoNumerico(costo) && validarDatoNumerico(tiempo) && validarDatoNumerico(cupo)) {
			this.tiempo = tiempo;
			this.costo = costo;
			this.cupo = cupo;
			this.disponible = disponible;
		} else
			throw new ErrorDatosException("Datos con valor negativo");

	}

	public int getCupo() {
		return this.cupo;
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

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return String.format("%-30s $%.0f \t %s hs. %n", nombre + " [" + tipo.getDescripcion() + "]", costo, tiempo);
	}

	@Override
	public List<Atraccion> getAtracciones() {
		return null;
	}

	@Override
	public boolean venderProducto() {
		return this.restarCupo();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCosto(double costo) {
		this.costo = costo;

	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;

	}

	public void setCupo(int cupo) {
		this.cupo = cupo;

	}

}
