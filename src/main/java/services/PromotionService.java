package services;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dao.AtraccionesDAO;
import dao.DAOFactory;
import dao.PromocionDAO;
import model.Atraccion;
import model.ErrorDatosException;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Tipo;
import model.TipoPromocion;

public class PromotionService {
	
	private PromocionDAO gestorPromociones = DAOFactory.getPromocionDAO();
	private AtraccionesDAO gestorAtracciones = DAOFactory.getAtraccionesDAO();
	
	public List<Promocion> list(Map<String, Atraccion> atracciones) {
		return this.gestorPromociones.findAllDisponible(atracciones);
	}
	
	public List<Promocion> listAll(Map<String, Atraccion> atracciones) {
		return this.gestorPromociones.findAll(atracciones);
	}
	
	public int createPromoPorcentual(String id, String nombre, String tipoPromo, String tipo, double descuento, String[] atraccionesPromo) throws ErrorDatosException {
		int resultado = 0;
		List<Atraccion> atracciones = this.listarAtracciones(atraccionesPromo);
		
		resultado = this.gestorPromociones.insert(new PromocionPorcentual(id, nombre, TipoPromocion.valueOf(tipoPromo), atracciones, Tipo.valueOf(tipo), descuento, true));
				
		return resultado;
	}	
	
	public int createPromoAbsoluta(String id, String nombre, String tipoPromo, String tipo, double costo, String[] atraccionesPromo) throws ErrorDatosException {
		int resultado = 0;
		List<Atraccion> atracciones = this.listarAtracciones(atraccionesPromo);
		
		resultado = this.gestorPromociones.insert(new PromocionAbsoluta(id, nombre, TipoPromocion.valueOf(tipoPromo), atracciones, Tipo.valueOf(tipo), costo, true));
				
		return resultado;
	}
	
	public int createPromoAXB(String id, String nombre, String tipoPromo, String tipo, String[] atraccionesPromo, String promoGratisID) throws ErrorDatosException {
		int resultado = 0;
		List<Atraccion> atracciones = this.listarAtracciones(atraccionesPromo);
		
		resultado = this.gestorPromociones.insert(new PromocionAxB(id, nombre, TipoPromocion.valueOf(tipoPromo), atracciones, this.gestorAtracciones.findAtraccionById(promoGratisID), Tipo.valueOf(tipo), true));
				
		return resultado;
	}
	
	private List<Atraccion> listarAtracciones(String[] atraccionesPromo){
		List<Atraccion> atraccionesLista = new LinkedList<Atraccion>();
		for(String atrID : atraccionesPromo) {
			atraccionesLista.add(this.gestorAtracciones.findAtraccionById(atrID));
		}
		return atraccionesLista;
	}
	

}
