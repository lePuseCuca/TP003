package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.jdbc.ConnectionProvider;
import model.ErrorDatosException;
import model.Tipo;
import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public List<Usuario> findAll() { 
		try {
			String sql = "SELECT * FROM USUARIOS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Usuario> usuarios = new ArrayList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() { 
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM USUARIOS";
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
	public int insert(Usuario usuario) { 
		try {
			String sql = "INSERT INTO usuarios (nombre, monedas, tiempo, tipo_preferido, clave, admin, disponible) VALUES (?, ?, ?, ?, ?, ?, 1)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setDouble(2, usuario.getPresupuesto());
			statement.setDouble(3, usuario.getTiempo());
			statement.setString(4, usuario.getTipoPreferido().toString());
			statement.setString(5, usuario.getClave());
			statement.setBoolean(6, usuario.isAdmin());
						
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Usuario usuario) { 
		try {
			String sql = "UPDATE usuarios SET nombre = ?, monedas = ?, tiempo = ?, tipo_preferido = ?, clave = ?, admin = ?, disponible = 1 WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setDouble(2, usuario.getPresupuesto());
			statement.setDouble(3, usuario.getTiempo());
			statement.setString(4, usuario.getTipoPreferido().toString());
			statement.setString(5, usuario.getClave());
			statement.setBoolean(6, usuario.isAdmin());
			statement.setString(7, usuario.getNombre());
			
						
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	@Override
	public int delete(Usuario usuario) {
		try {
//			String sql = "DELETE FROM usuarios WHERE nombre = ?";
			String sql = "UPDATE usuarios SET DISPONIBLE = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, false); //Funciona con as?? con bool???
			statement.setString(2, usuario.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}

	@Override
	public Usuario findUsuarioByNombre(String nombre) {
		try {
			String sql = "SELECT * FROM usuarios WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = null;

			if (resultados.next()) {
				usuario = toUsuario(resultados);
			}

			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}
	
	private Usuario toUsuario(ResultSet resultados) throws SQLException, ErrorDatosException {
		return new Usuario(resultados.getString("nombre"), 
				resultados.getDouble("monedas"),
				resultados.getDouble("tiempo"),
				Tipo.valueOf(resultados.getString("tipo_preferido")), 
				resultados.getString("clave"),
				resultados.getBoolean("admin"));
	}

	@Override
	public int updateStatus(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
