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
		return this.gestorUsuarios.findUsuarioByNombre(nombre);
		
	}
}
