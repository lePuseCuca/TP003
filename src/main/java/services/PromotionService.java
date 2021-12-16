package services;

import java.util.List;
import java.util.Map;

import dao.DAOFactory;
import dao.PromocionDAO;
import model.Atraccion;
import model.Promocion;

public class PromotionService {
	
	private PromocionDAO gestorPromociones = DAOFactory.getPromocionDAO();
	
	public List<Promocion> list(Map<String, Atraccion> atracciones) {
		return this.gestorPromociones.findAll(atracciones);
	}

}
