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
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		for(String atrID : atraccionesPromo) {
			atracciones.add(this.gestorAtracciones.findAtraccionById(atrID));
		}
		
		resultado = this.gestorPromociones.insert(new PromocionPorcentual(id, nombre, TipoPromocion.valueOf(tipoPromo), atracciones, Tipo.valueOf(tipo), descuento, true));
				
		return resultado;
	}	
	

}
