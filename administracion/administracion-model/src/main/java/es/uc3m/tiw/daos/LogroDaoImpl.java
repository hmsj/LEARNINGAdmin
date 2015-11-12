package es.uc3m.tiw.daos;

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
	
}
