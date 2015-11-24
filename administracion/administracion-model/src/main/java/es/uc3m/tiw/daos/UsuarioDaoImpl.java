package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

	@Override
	public Usuario comprobarUsuarioUsernamePass(String username, String password)
			throws Exception {
		Usuario usuario =null;
		usuario = em.createQuery("SELECT u FROM Usuario u where u.username='"+username+"' and u.password='"+password+"'",Usuario.class).getSingleResult();
		return usuario;
	}

	@Override
	public List<Usuario> findAll() throws Exception {
		List<Usuario> listaUsuarios = em.createQuery("SELECT u from Usuario u",Usuario.class).getResultList();
		return listaUsuarios;
	}

	@Override
	public void removeUsuario(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(usuario));
		ut.commit();
	}

	@Override
	public Usuario findByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Usuario.class, new String(username));
	}
	
}
