package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public UsuarioDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Usuario createUsuario(Usuario usuarioNuevo) throws Exception{
		ut.begin();
		em.persist(usuarioNuevo);
		ut.commit();
		return usuarioNuevo;
	}
	
}
