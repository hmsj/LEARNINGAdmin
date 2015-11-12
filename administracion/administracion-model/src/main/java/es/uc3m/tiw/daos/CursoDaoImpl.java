package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Curso;

public class CursoDaoImpl implements CursoDao{
	private EntityManager em;
	private UserTransaction ut;

	public CursoDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Curso createCurso(Curso cursoNuevo) throws Exception{
		ut.begin();
		em.persist(cursoNuevo);
		ut.commit();
		return cursoNuevo;
	}
	
}
