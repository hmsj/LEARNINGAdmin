package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.AlumnoCurso;

public class AlumnoCursoDaoImpl implements AlumnoCursoDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public AlumnoCursoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public AlumnoCurso createAlumnoCurso(AlumnoCurso alumnoCursoNuevo) throws Exception {
		ut.begin();
		em.persist(alumnoCursoNuevo);
		ut.commit();
		return alumnoCursoNuevo;
	}
}
