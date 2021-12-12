package services;

import dao.DAOFactory;
import dao.UsuarioDAO;
import model.Usuario;
import model.nullobjects.*;

public class LoginService {
	public Usuario login(String nombre, String clave) {
		UsuarioDAO usuarioDao = DAOFactory.getUsuarioDAO();
    	Usuario usuario = usuarioDao.findUsuarioByNombre(nombre);
    	
    	if(usuario != null)
    		if (!usuario.getClave().equals(clave)) 
    			usuario = null;
    	/*
    	if (usuario.isNull() || !usuario.checkClave(clave)) {
    		usuario = NullUsuario.build();
    		*/
    	
    	return usuario;
	}
}
