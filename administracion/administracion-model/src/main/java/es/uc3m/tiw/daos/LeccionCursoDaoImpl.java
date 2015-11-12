package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.LeccionCurso;

public class LeccionCursoDaoImpl implements LeccionCursoDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public LeccionCursoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public LeccionCurso createLeccionCurso(LeccionCurso leccionCursoNueva) throws Exception{
		ut.begin();
		em.persist(leccionCursoNueva);
		ut.commit();
		return leccionCursoNueva;
	}
	
}
