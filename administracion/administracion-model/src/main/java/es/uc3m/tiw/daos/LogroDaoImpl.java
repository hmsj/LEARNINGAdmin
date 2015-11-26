package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Logro;

public class LogroDaoImpl implements LogroDao{
	private EntityManager em;
	private UserTransaction ut;

	public LogroDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Logro createLogro(Logro logroNuevo) throws Exception{
		ut.begin();
		em.persist(logroNuevo);
		ut.commit();
		return logroNuevo;
	}

	@Override
	public List<Logro> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Logro> listadoLogros = em.createQuery("SELECT l from Logro l", Logro.class).getResultList();
		return listadoLogros;
	}

	@Override
	public Logro findById(int idLogro) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Logro.class, new Integer(idLogro));
	}
	
}
