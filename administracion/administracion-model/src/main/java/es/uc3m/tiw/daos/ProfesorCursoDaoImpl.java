package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.ProfesorCurso;

public class ProfesorCursoDaoImpl implements ProfesorCursoDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public ProfesorCursoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public ProfesorCurso createProfesorCurso(ProfesorCurso profesorCursoNuevo) throws Exception{
		ut.begin();
		em.persist(profesorCursoNuevo);
		ut.commit();
		return profesorCursoNuevo;
	}
}
