package es.uc3m.tiw.daos;

import es.uc3m.tiw.model.Usuario;

public interface UsuarioDao {
	
	public abstract Usuario createUsuario(Usuario usuarioNuevo) throws Exception;

}
