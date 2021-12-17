package services;

import java.util.List;

import dao.DAOFactory;
import dao.UsuarioDAO;
import model.ErrorDatosException;
import model.Tipo;
import model.Usuario;

public class UserService {
	private UsuarioDAO gestorUsuarios = DAOFactory.getUsuarioDAO();

	public int update(Usuario usuario) {
		return this.gestorUsuarios.update(usuario);
	}

	public Usuario find(String nombre) {
		return this.gestorUsuarios.findUsuarioByNombre(nombre);
	}

	public List<Usuario> list() {
		return this.gestorUsuarios.findAll();
	}

	public int create(
			String nombre, double monedas, double tiempo, 
			Tipo tipoPreferido, String clave, boolean isAdmin) throws ErrorDatosException {
		Usuario usuario = new Usuario(nombre, monedas, tiempo, tipoPreferido, clave, isAdmin);
		return this.gestorUsuarios.insert(usuario);
	}

	public int delete(String usuarioId) {
		return this.gestorUsuarios.delete(this.find(usuarioId));
	}
	
	//Usuario necesita ID porque nombre esta como PK en tabla usuarios y como FK en itinerarios.
	public int edit(Usuario usuario, String nombre, Double monedas, Double tiempo, 
			Tipo tipoPreferido, String clave, Boolean isAdmin) {
		
		usuario.setNombre(nombre);
		usuario.setPresupuesto(monedas);
		usuario.setTiempo(tiempo);
		usuario.setTipoPreferido(tipoPreferido);
		usuario.setClave(clave);
		usuario.setAdmin(isAdmin);
		
		return this.update(usuario);
	}
}
