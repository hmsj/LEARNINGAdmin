package es.uc3m.tiw.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.model.Direccion;

public class DireccionDaoImpl implements DireccionDao{
	private EntityManager em;
	private UserTransaction ut;
	
	public DireccionDaoImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Direccion createDireccion(Direccion direccionNueva) throws Exception{
		ut.begin();
		em.persist(direccionNueva);
		ut.commit();
		return direccionNueva;
	}

	@Override
	public void removeDireccion(Direccion direccion) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(direccion));
		ut.commit();
	}

	@Override
	public Direccion modifyDireccion(Direccion direccion) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(direccion);
		ut.commit();
		return direccion;
	}
	
	@Override
	public Direccion findById(Long idDireccion) throws Exception {
		// TODO Auto-generated method stub
		return em.find(Direccion.class, new Long(idDireccion));
	}
	
}
