package model;

import utils.Crypt;

public class Usuario {
	private String nombre;
	private double monedas;
	private double tiempo;
	private Tipo tipoPreferido;
	private String clave;
	private Boolean admin;

	public Usuario() {
	}

	public Usuario(String nombre, double monedas, double tiempo, Tipo tipoPreferido, String clave, Boolean admin)
			throws ErrorDatosException {

		if (validarDato(monedas) && validarDato(tiempo)) {
			this.nombre = nombre;
			this.monedas = monedas;
			this.tiempo = tiempo;
			this.tipoPreferido = tipoPreferido;
			this.clave = clave;
			this.admin = admin;
		} else
			throw new ErrorDatosException("Datos con valor negativo");

	}

	public String getNombre() {
		return this.nombre;
	}

	public double getPresupuesto() {
		return this.monedas;
	}
	
	public double getMonedas() {
		return this.monedas;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public Tipo getTipoPreferido() {
		return this.tipoPreferido;
	}

	public String getClave() {
		return this.clave;
	}

	public Boolean isAdmin() {
		return this.admin;
	}

	// ----------

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPresupuesto(double monedas) {
		this.monedas = monedas;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public void setTipoPreferido(Tipo tipoPreferido) {
		this.tipoPreferido = tipoPreferido;
	}

	public void setClave(String clave) {
		// this.clave = Crypt.hash(clave);
		this.clave = clave;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	private boolean validarDato(double dato) {
		return (dato >= 0);
	}

	public boolean isNull() {
		return false;
	}
	/*
	 * public boolean checkClave(String clave) {
	 * 
	 * return Crypt.match(clave, this.clave);
	 * 
	 * }
	 */

	public void comprarProducto(Producto producto) {
		this.monedas -= producto.getCosto();
		this.tiempo -= producto.getTiempo();		
	}
}