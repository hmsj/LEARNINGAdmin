package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.SeccionCurso;

public class SeccionCursoDaoImpl implements SeccionCursoDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public SeccionCursoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public SeccionCurso createSeccionCurso(SeccionCurso seccionCursoNueva) throws Exception{
		ut.begin();
		em.persist(seccionCursoNueva);
		ut.commit();
		return seccionCursoNueva;
	}
}
