package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dao.jdbc.ConnectionProvider;
import model.Atraccion;
import model.ErrorDatosException;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.Tipo;
import model.TipoPromocion;

public class PromocionDAOImpl implements PromocionDAO {

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM promociones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Promocion promo) {
		return 0;
	}
	
	@Override
	public int update(Promocion promo) {
		return 0;
	}

	@Override
	public int delete(Promocion promo) {
		return 0;
	}
	
	@Override
	public List<Promocion> findAll() {
		return null;
	}

	@Override
	public List<Promocion> findAll(Map<String, Atraccion> atracciones) {
		try {
			String sql = "SELECT * FROM promociones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Promocion> promociones = new LinkedList<Promocion>();
			while (resultados.next()) {
				promociones.add(toPromocion(resultados, atracciones));
			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promocion toPromocion(ResultSet resultados, Map<String, Atraccion> atracciones) throws SQLException {
		Promocion promoNueva = null;
		
		List<String> atraccionesPromo = findAtracionesPromo(resultados.getString("id"));
		List<Atraccion> tempAt = new ArrayList<Atraccion>();
		
		boolean atraccionInexistente = false;
		
		for(String idAtr : atraccionesPromo)
			if(atracciones.containsKey(idAtr))
				tempAt.add(atracciones.get(idAtr));
			else
				atraccionInexistente = true; 
		
		String tipoPromo = resultados.getString("tipo_promocion");
		switch (tipoPromo) {
		case "PORCENTUAL":
			if(!atraccionInexistente) {
				try {
					promoNueva = new PromocionPorcentual(
							resultados.getString("id"),
							resultados.getString("nombre"), 
							TipoPromocion.valueOf(tipoPromo), 
							tempAt,
							Tipo.valueOf(resultados.getString("tipo_atracciones")),
							Double.parseDouble(resultados.getString("descuento"))); 
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ErrorDatosException e) {
					System.err.println("Error en datos de promociones: " + e.getMessage() + ".\nAlgunos productos no se cargaron correctamente.");
				}
			}
			break;			
		case "ABSOLUTA":
			if(!atraccionInexistente) {
				try {
					promoNueva = new PromocionAbsoluta(
								resultados.getString("id"),
								resultados.getString("nombre"), 
								TipoPromocion.valueOf(tipoPromo), 
								tempAt,
								Tipo.valueOf(resultados.getString("tipo_atracciones")),
								Double.parseDouble(resultados.getString("descuento")));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ErrorDatosException e) {
					System.err.println("Error en datos de promociones: " + e.getMessage() + ".\nAlgunos productos no se cargaron correctamente.");
				}
			}
			break;
		case "AxB":			
			if(!atraccionInexistente && atracciones.containsKey(resultados.getString("descuento"))) {
				promoNueva = new PromocionAxB(
						resultados.getString("id"),
						resultados.getString("nombre"), 
						TipoPromocion.valueOf(tipoPromo), 
						tempAt,
						atracciones.get(resultados.getString("descuento")),
						Tipo.valueOf(resultados.getString("tipo_atracciones")));
			}
			break;
		}	
		
		return promoNueva;
	}

	private List<String> findAtracionesPromo(String id) {
		try {
			String sql = "SELECT id_atraccion \n"
					+ "FROM promocion_atracciones\n"
					+ "WHERE id_promocion = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultados = statement.executeQuery();

			List<String> atraccionesPromo = new LinkedList<String>();
			
			while (resultados.next()) {
				atraccionesPromo.add(resultados.getString("id_atraccion"));
			}
			return atraccionesPromo;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}


	

}