package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.model.Usuario;

public interface UsuarioDao {
	
	public abstract Usuario createUsuario(Usuario usuarioNuevo) throws Exception;

	public abstract Usuario comprobarUsuarioUsernamePass (String username, String password) throws Exception;

	public abstract List<Usuario> findAll() throws Exception;

	public abstract void removeUsuario (Usuario usuario) throws Exception;
	
	public abstract Usuario findByUsername(String username) throws Exception;

}
