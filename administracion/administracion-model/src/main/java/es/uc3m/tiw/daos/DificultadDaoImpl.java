package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Dificultad;

public class DificultadDaoImpl implements DificultadDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public DificultadDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Dificultad createDificultad(Dificultad dificultadNueva) throws Exception{
		ut.begin();
		em.persist(dificultadNueva);
		ut.commit();
		return dificultadNueva;
	}
	
}
