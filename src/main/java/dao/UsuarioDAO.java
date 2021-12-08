package dao;

import model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	
	public abstract Usuario findUsuarioByNombre(String nombre);
	
}