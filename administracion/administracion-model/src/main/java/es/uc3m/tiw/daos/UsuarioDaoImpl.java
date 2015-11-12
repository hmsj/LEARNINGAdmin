package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Curso;
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
		Query query =  em.createQuery("SELECT u FROM Usuario u where u.username=:username and u.password=:password", Usuario.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		return (Usuario) query.getSingleResult();
	}

	@Override
	public List<Usuario> findAll() throws Exception {
		List<Usuario> listaUsuarios = em.createQuery("SELECT u from Usuario u",Usuario.class).getResultList();
		return listaUsuarios;
	}
	
}
