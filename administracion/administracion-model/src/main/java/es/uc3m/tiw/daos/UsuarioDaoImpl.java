package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
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
		Query q = em.createQuery("select u from Usuario u where u.username='"+username+"' and u.password='"+password+"'",Usuario.class);
		q.setParameter("username", username);
		q.setParameter("passwor", password);
		return (Usuario) q.getSingleResult();
	}

	@Override
	public List<Usuario> findAll() throws Exception {
		List<Usuario> listaUsuarios = em.createQuery("SELECT u from Usuario u",Usuario.class).getResultList();
		return listaUsuarios;
	}
	
}
