package es.uc3m.tiw.daos;

import java.util.List;

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

	@Override
	public List<Dificultad> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Dificultad> listadoDificultad = em.createQuery("SELECT d from Dificultad d",Dificultad.class).getResultList();
		return listadoDificultad;
	}

	@Override
	public Dificultad findById(int idDificultad) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Dificultad.class, new Integer(idDificultad));
	}
	
}
