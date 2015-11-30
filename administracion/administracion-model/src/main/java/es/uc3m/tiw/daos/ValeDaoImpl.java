package es.uc3m.tiw.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Vale;

public class ValeDaoImpl implements ValeDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public ValeDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Vale createVale(Vale valeNuevo) throws Exception{
		ut.begin();
		em.persist(valeNuevo);
		ut.commit();
		return valeNuevo;
	}

	@Override
	public void removeVale(Vale vale) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(vale));
		ut.commit();
	}
	
	@Override
	public List<Vale> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Vale> listadoVales = em.createQuery("SELECT p FROM Vale p", Vale.class).getResultList();
		return listadoVales;
	}

	@Override
	public Vale findById(Long idVale) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Vale.class, new Long(idVale));
	}

}
