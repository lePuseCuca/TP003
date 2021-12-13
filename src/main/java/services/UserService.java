package services;

import dao.DAOFactory;
import dao.UsuarioDAO;
import model.Usuario;

public class UserService {
	private UsuarioDAO gestorUsuarios = DAOFactory.getUsuarioDAO();

	public void update(Usuario usuario) {
		this.gestorUsuarios.update(usuario);
	}

	public Usuario find(String nombre) {
		this.gestorUsuarios.findUsuarioByNombre(nombre);
		return null;
	}
}
