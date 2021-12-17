package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.jdbc.ConnectionProvider;
import model.Atraccion;
import model.ErrorDatosException;
import model.Tipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtraccionesDAOImpl implements AtraccionesDAO {

	// CHEQUEAR SI EL WHERE DISPONIBLE PARA VALIDAR EN LA BASE ESTA OK

	@Override
	public Map<String, Atraccion> findAllAtracciones() {
		try {
			String sql = "SELECT * FROM ATRACCIONES";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			Map<String, Atraccion> atracciones = new HashMap<String, Atraccion>();
			while (resultados.next()) {
				atracciones.put(resultados.getString("id"), toAtraccion(resultados));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
			
	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM ATRACCIONES WHERE DISPONIBLE = 1";
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
	public int insert(Atraccion atr) {
		try {
			String sql = "INSERT INTO ATRACCIONES (ID, NOMBRE, TIEMPO, COSTO, CUPO, TIPO, DISPONIBLE) VALUES (?, ?, ?, ?, ?, ?, 1)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atr.getId());
			statement.setString(2, atr.getNombre());
			statement.setDouble(3, atr.getTiempo());
			statement.setDouble(4, atr.getCosto());
			statement.setInt(5, atr.getCupo());
			statement.setObject(6, atr.getTipo());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Atraccion atr) {
		try {
			String sql = "UPDATE ATRACCIONES SET NOMBRE = ?, TIEMPO = ?, COSTO = ?, CUPO = ?, TIPO = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atr.getNombre());
			statement.setDouble(2, atr.getTiempo());
			statement.setDouble(3, atr.getCosto());
			statement.setInt(4, atr.getCupo());
			statement.setObject(5, atr.getTipo());
			statement.setString(6, atr.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	@Override
	public int updateStatus(Atraccion atr) {
		try {
			String sql = "UPDATE atracciones SET disponible = ((disponible | 1) - (disponible & 1)) WHERE id = ?";
			//String sql = "UPDATE ATRACCIONES SET DISPONIBLE = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, atr.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Atraccion atr) {
		try {
			String sql = "UPDATE ATRACCIONES SET DISPONIBLE = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, false);
			statement.setString(2, atr.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Atraccion findAtraccionById(String id) {
		try {
			String sql = "SELECT * FROM ATRACCIONES WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultados = statement.executeQuery();

			Atraccion atr = null;

			if (resultados.next()) {
				atr = toAtraccion(resultados);
			}

			return atr;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet resultados) throws SQLException, ErrorDatosException {
		return new Atraccion(resultados.getString("id"), resultados.getString("nombre"), resultados.getDouble("tiempo"), resultados.getDouble("costo"),
				resultados.getInt("cupo"), Tipo.valueOf(resultados.getString("tipo")), resultados.getBoolean("disponible"));
	}

	@Override
	public List<Atraccion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
